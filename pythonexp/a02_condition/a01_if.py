'''
Created on 2022. 12. 21.

@author: LG
'''


'''
# if문 
1. 기본형식
    1) 파이썬은 {}중괄호 블럭이 없다
        - 하위 계층단계를 구분할 때는 tab간격/공백간격을 처리한다
        - 반드시 같은 level을 계층코드는 같은 탭이나 공백 간격을 유지하여야 한다
    2) 조건문 처리형식
        if 비교/논리연산식 :
            처리내용1
            처리내용2
           처리내용3(x) 에러발생 : 반드시 동일한 공백간격 유지
'''

print("프로그램 시작")
num01 = 199
if num01 >= 100 :
    print("100보다 크네요1")
    print("100보다 크네요2")
    print("100보다 크네요3")
print("프로그램 종료")

# ex) 물건의 가격을 입력받아서 100000이상일 때 슈퍼유저로 표현하세요
print("당신이 모은 포인트로 슈펴유저 판별(시작)")
point01 = int(input("가격을 입력하세요: "))
if point01 >= 100000 :
    print("당신은 슈퍼유저")
print("슈펴유저 판별(종료)")    


'''
2. if else구문
    1) 조건문을 분기처리할 때 활용된다
    2) 형식
        if 조건1:
            처리문장1
        elif 조건2:
            처리문장2
        else:
            기타조건일때 처리문장        
'''
pt = 80
if pt>= 70:
    print("합격")
else :
    print("불합격")
       
print("if elif구문")    
if pt>=90:
    print("A학점")
elif pt>=80: 
    print("B학점")    
elif pt>=70: 
    print("C학점")    
elif pt>=60: 
    print("D학점")   
else:
    print("F학점") 
     
# ex1) 로그인 himan/7777일 때 로그인 성공 그외는 로그인 실패
print()
print("--로그인--")
id01 = input("아이디_")
pass01= input("비밀번호_")
if id01=="himan" and pass01=="7777":
    print("로그인 성공")
else:
    print("로그인 실패")    
# ex2) 나이에 따라 5세 미만 65세 이상 무료, 6~13 50%, 14~18 30% 입장료 할인하여 출력하세요 기본입장료 50000
print()
entryfee = 50000
disRatio = 0.0

print("--입장료 계산--")
age01 = int(input("나이를 입력하세요_"))
if age01<5 or age01>=65:
    disRatio=0.0
elif age01<=13:
    disRatio=0.5
elif age01<=18:
    disRatio=0.7
else:
    disRation=1.0 #의미없네요
tot = int(entryfee*disRatio) #소수점 이하 절삭
print("나이:", age01)        
print("최종금액:",tot)

     