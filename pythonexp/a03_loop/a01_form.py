'''
Created on 2022. 12. 22.

@author: LG
'''

'''
# for문 형식
1. for idx in range(반복횟수) : 반복회수만큼 0부터 반복
2. for cnt in range(시작 수, 마지막 수+1) : 시작수에서 마지막 수까지 반복
3. for cnt in range(시작 수, 마지막 수+1/-1, 증감단위) : 시작수에서 마지막수까지 증/감단위로 반복
4. for one in 배열형구조체 : 배열형 데이터를 한개씩 출력 처리
'''
# 5회 반복(0부터 시작)
for idx in range(5):
    print(idx, end=",")
print()

# 1~10까지 출력
for cnt in range(1, 11):
    print(cnt, end=",")
print()   

# 10~100까지 5단위로 출력
for cnt in range(10, 101, 5):
    print(cnt, end=",")
print()     


# ex1) 5~17까지 출력
for cnt in range(5,18):
    print(cnt, end=",")
print()
# ex2) 10~50까지 3단위로 출력
for cnt in range(10, 51, 3):
    print(cnt, end=",")
print()
# ex3) 99~77까지 2단위로 감소 출력
for cnt in range(99, 76, -2):
    print(cnt, end=",")
print()


'''
# list 형태 구조체
1. 배열형태의 데이터이다
    변수명=[]
    변수명=[데이터1, 데이터2, 데이터3]
    변수명[0]
    변수명[1]
    변수명[2]
    len(변수명) : 개수
    변수명.append(추가데이터)
'''
list01 = [5, 7, 10]
list02 = ["홍길동", "김길동", "신길동"]
print(list01[0], len(list01))
print(list02[0], len(list02))
list01.append(15)
list02.append("마길동")
print(list01, list02)

#4. for one in 배열형구조체 : 배열형 데이터를 한개씩 출력 처리
for num01 in list01:
    print(num01, end=" ")
print()
for fruit in ["사과", "딸기", "바나나"]:
    print(fruit, end="!")
print()    

# ex) 즐겨먹는 점심메뉴 3가지 배열로 선언하고 for문을 통해서 출력
for launch in ["바질파스타", "닭가슴살볶음밥", "은희네해장국"]:
    print(launch, end=", ")
print()    






'''
# 파이썬의 임의의 수 생성
1. 기본 형식
    1) import random as ran
    2) 기능 메서드
        ran.random() (0<=R<1.0)
        ran.randrange(시작번호, 범위+1) : 시작번호에서 특정 범위의 수를 random으로 정수를 가져올 때 사용
        ex) 1~10 : ran.randrange(1, 11)
            10~20 : ran.randrange(10,21)
'''
import random
import random as r # 변수명을 조금 더 간단하게 쓸 수 있다
print(random.random())
print(r.randrange(1, 11))
# ex) random모듈을 이용하여 주사위 2개를 던져 그 합을 출력하세요
dice1 = r.randrange(1,7)
dice2 = r.randrange(1,7)
print(dice1, dice2, dice1+dice2)




    