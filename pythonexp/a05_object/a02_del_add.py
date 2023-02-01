'''
Created on 2022. 12. 23.

@author: LG
'''
from hamcrest.core.core.isnone import none


class Person:
    def __init__(self, name):
        self.name = name
        print(self.name, ">>객체 생성")
    def __del__(self):
        print(self.name, ">>객체 소멸")

'''
# 메모리 해제 순간
1. 모든 코드가 처리가 되고 끝나는 마지막 라인
2. 코드 중간에 명시적 메모리 해제 함수 del(참조명) 호출 시
'''
p01 = Person("이지원")            
p02 = Person("이지수")            
p03 = Person("이지우")   
print("안녕하세요") 
        
print("명시적 객체 소멸")       
del(p01)

print("마지막라인(묵시적 개체 소멸)")  



# ex) Product를 통해 물건명과 가격을 생성자를 통해 할당하고 소멸자를 통해서 물건명은 None으로 가격은 0으로 초기화하여
#     소멸되게 처리하여 물건 객체 두개를 하나는 명시적 소멸자로 하나는 묵시적 소멸자로 호출되어 출력하게 하세요
class Product:
    def __init__(self, pname, price):
        self.pname = pname
        self.price = price
        print(self.pname, self.price,"<<생성자로 필드값 할당")
    def __del__(self): 
        print(self.pname,"<<해당 제품 소멸")   
        self.pname = None
        self.price = 0
               
prd01 = Product("아메리카노", 2500)        
prd02 = Product("카페라떼", 3500)  
prd03 = Product("자몽허니블랙티", 4500)  
 
print("명시적 초기화"); del(prd01)      
print("묵시적 초기화(라인 마지막)");    


'''
# __add__() 메서드
1. 객체까지 참조값으로 덧셈연산을 처리하는 경우에 실행되는 메소드
    ex) p01 = Product()
        p02 = Product()
        p01+p02
'''
class Rabbit:
    def __init__(self, kind):
        self.kind = kind
        print(kind, "객체 생성")
    def __add__(self, other):
        print("Rabbit클래스의 "+self.kind+"와 "+other.kind+"가 친구가 되었습니다")    

r1 = Rabbit("빨간 머리 토끼")
r2 = Rabbit("곱슬 머리 토끼")
r1 + r2











