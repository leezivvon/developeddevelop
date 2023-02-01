'''
Created on 2022. 12. 23.

@author: LG
'''
from hamcrest.core.core.isnone import none
from plotly.graph_objs.waterfall import totals

class Person:
    name= None  #객체의 초기값 null대신에 None을 사용
    age= 0
    
p01 = Person()
p01.name='홍길동'    
p01.age = 25
print("이름:",p01.name)
print("나이:",p01.age)

# ex) 물건 객체 선언 : 물건명/가격/개수 : 데이터 할당 후 출력하세요
class Product:
    pname = None
    price = 0
    cnt = 0
prd01 = Product()
prd01.pname = '와플'    
prd01.price = 2100
prd01.cnt = 1  
print(prd01.pname,"이 ",prd01.cnt,"개에 ", prd01.price,"원")


class Food:
    def __init__(self, name, price):
        self.name = name    #self :구성요소를 지칭
        self.price = price
f01 = Food("탕수육", 18000)        
f02 = Food("누룽지탕", 24000)
print(f01.name, f01.price)        
print(f02.name, f02.price)   

# ex) 축구선수를 클래스로 선언하고 속성으로 팀명 이름 골 수를 생성자로 할당하여 출력하세요
class Soccer:
    def __init__(self, tname, player, goal):
        self.tname = tname
        self.player = player
        self.goal = goal
s01 = Soccer("토트넘", "손흥민", 300)             
s02 = Soccer("전북 현대", "조규성", 200)       
print(s01.tname,"에서 ", s01.player,"이", s01.goal,"골로 epl득점 왕")      
print(s02.tname,"에서 ", s02.player,"이", s02.goal,"골로 K리그 득점 왕")      


class Calculator:
    def __init__(self, num01, num02):
        self.num01 = num01
        self.num02 = num02
    def plus(self):
        print(self.num01,"+",self.num02,"=",self.num01+self.num02) 
        return self.num01+self.num02
c01 = Calculator(25, 3)
tot = c01.plus()           
print("합산:", tot)

# ex) Product02를 선언하고 생성자로 물건명과 가격 buy(구매개수)로 해당 물건명과 가격과 구매개수를 출력하되
#     총계를 해당 메서드를 통해서 return처리하여 호출하세요
class Product02:
    def __init__(self, pname, price):
        self.pname = pname
        self.price = price
    def buy(self, cnt):        
        self.cnt = cnt
        print("구매내역")
        print(self.pname, self.cnt, self.price,"원") 
        return self.cnt*self.price 
    
prd02 = Product02("피땅콩", 20000)
print("총계:",prd02.buy(3))
prd03 = Product02("우유", 3400)           
print("총계:",prd03.buy(2))