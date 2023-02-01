'''
Created on 2022. 12. 28.

@author: LG
'''

# 기능메서드 활용

# 1. arange(크기) 해당 크기만큼의 배열을 생성
#    1) 0부터 시작하여 증가되는 데이터로 해당 크기만큼 설정
import numpy as np
ar01 = np.arange(10) 
print(ar01) #[0 1 2 3 4 5 6 7 8 9]
# 2. arange(시작값, 마지막값+1)
ar02 = np.arange(10, 20) 
print(ar02) #[10 11 12 13 14 15 16 17 18 19]
# 3. arange(시작값, 마지막값+1, 증감단위)
ar03 = np.arange(20, 10, -2)
print(ar03)
# ex) arange기능 메서드를 이용하여 50~70, 4~15까지 데이터가 들어간 배열을 선언해보세요
ar04 = np.arange(50, 71) 
ar05 = np.arange(4, 16)
print(ar04, ar05)

# 범위에 데이터는 나누어서 처리
# 1. linspace(시작값, 마지막값, 분할할 개수)
ar06 = np.linspace(0,1,6)
print(ar06)

# 2. np.linspace(시작값, 마지막값, 분할할 개수, endpoint=False)
#    마지막값이 포함되는 것이 default
#    마지막값을 포함시키지 않으려면 endpoint속성 활용
ar07 = np.linspace(0, 10, 4, endpoint=False)
print(ar07)

# ex1) 0~100 사이의 구간을 5개 구간으로 나누어 출력
ar08 = np.linspace(0, 100, 5)
print(ar08)
# ex2) 1~7사이의 구간을 6개로 나누어서 출력하되 마지막 값 포함하지 않게 처리
ar09 = np.linspace(1, 7 , 6, endpoint=False)
print(ar09)



'''
# 행렬의 변경되는 구조 만들기 reshape
1. 1차원의 특정 데이터의 행/열을 지정해서 2차원의 데이터로 변형시켜주는 역할을 한다
2. 기본형식
    ndarray.reshape(행, 열)
'''
ar10 = np.arange(10)
ar11 = ar10.reshape(2, 5)
print(ar10)
print(ar11)

# ex) 1~16까지 배열데이터를 4X4 형태의 ndarray로 출력하세요
ar12 = np.arange(1, 17).reshape(4, 4)
print(ar12)
# ex) 1~21까지 배열데이터 3X7형태로 출력
ar13 = np.arange(1, 22).reshape(3, 7)
print(ar13)

'''
# 초기값이 1이나 0으로 default값을 설정하여 배열크기로 설정하는 메서드
1. 1로 채워서 배열을 만드는 경우
    .ones(크기설정)
2. 0으로 채워서 배열을 만드는 경우
    .zeros(크기설정)
3. 위 내용에서 특정한 행열로 만드는 경우
    .zeros((행, 열))
'''
ar14 = np.ones(10)
ar15 = np.zeros(10)
print(ar14, ar15)
ar16 = np.ones((4, 4))
ar17 = np.zeros((3, 3))
print(ar16)
print(ar17)
# ex) 0으로 5X4데이터를 출력하세요
print( np.zeros((5, 4)) )

'''
# 0으로 입력된 열/행 데이터에서 1로 대각선을 데이터를 초기화 하는 eye()
1. 행/열 데이터를 0으로 처리되는 가운데 대각선 데이터 처리를 하되
2. k 속성에 의해 행이 한 칸씩 위로 아래로 이동 처리하는 경우
3. 기본 형식
    np.eye(행/열단위, dtype=int) :기본데이터 형식
    np.eye(행/열단위, k=변수)  : 1출력을 행단위로 아래 위로 변형
'''
print(np.eye(5, dtype=int))
print(np.eye(5, k=1))
print(np.eye(5, k=-1))
print(np.eye(5, k=2))
# ex) 3X3의 형식에 아래로 한 칸 밑에 1로 채워지는 데이터 처리를 하세요
print(np.eye(3, k=-1))


'''
# 사선의 데이터를 추출해주는 diag
1. 행렬데이터에서 사선에 있느 데이터만 추출할 때 사용된다
2. 기본형식
    1) np.diag(ndarray) : 왼쪽 상단부터 아래쪽 하단 끝의 사선데이터를 추출
    2) np.diag(ndarray, k=변수) : 위 기준으로 아래 위로 행을 변경할 때 사용
'''
ar18 = np.arange(25).reshape(5,5)
print(ar18)
print(np.diag(ar18))
print(np.diag(ar18, k=1))
print(np.diag(ar18, k=-2))

# ex1) 1~16까지 4X4데이터에서 사선데이터를 추출하여 출력하세요
ar19 = np.arange(1, 17).reshape(4, 4)
print(ar19)
print(np.diag(ar19))
# ex2) 100~76까지 5X5데이터에서 사선데이터(두칸아래행)를 추출해서 출력하세요
ar20 = np.arange(100, 75, -1).reshape(5, 5)
print(ar20)
print(np.diag(ar20, k=-2))


