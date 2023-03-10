'''
Created on 2022. 12. 21.

@author: LG
'''


'''
# 4가지 기본 데이터유형
1. 데이터유형을 확인하는 함수 :  type()
    int, float, str, bool
'''
var1 = 100
var2 = 3.14
var3 = '파이썬'
var4 = True
print(var1, type(var1))
print(var2, type(var2))
print(var3, type(var3))
print(var4, type(var4))

'''
2. 해당 데이터유형()으로 형변환처리가 가능하다
'''
var5 = int(var2) # 절삭을 통해 정수형 변환
var6 = str(var1) # 문자열으로 변환하여 +로 문자와 함께 출력 가능
var7 = float("75.67") # 숫자형 문자열을 숫자로 변환
print(var5, var6, var7)
print("첫번째 숫자: "+ var6)

'''
3. 문자열 데이터 선언
    1) "", '' 선언이 가능
    2) """를 통해서 여러줄 문자열 선언이 가능하다
'''
var8 = '''라인1
라인2
라인3
'''
var9 = """라인1
라인2
라인3(여러줄)
"""
print("여러라인1: ", var8)
print("여러라인2: ", var9)

'''
# 문자열은 + 이외에 -, *,/ 연산자를 사용하지 못한다
단, "문자열"*숫자 형태로 문자열 반복처리는 가능하다
'''
print("안녕하세요!!^^"*10)







'''
# 문자열에서 데이터 mapping처리 방식
1. 기본형식
    "문자열 데이터 {0},{1},{2}".format(넘길데이터1, 데이터2, 데이터3)
'''
str01 = "안녕하세요"
print("인사말:{0} 입니다".format(str01))

# ex) 가장 좋아하는 전자제품은 @@@,@@@,@@@입니다. format을 활용하여 출력하세요
print("가장 좋아하는 전자제품은 {0},{1},{2}입니다.".format("헤드폰", "핸드폰", "TV"))
#정답
eleProd1 = "서마터폰"
eleProd2 = "테레비"
eleProd3 = "엠피뜨리"
print('''
가장 좋아하는 전자제품은
1) {}
2) {}
3) {}
입니다.'''.format(eleProd1,eleProd2,eleProd3))




