'''
Created on 2022. 12. 26.

@author: LG

'''


'''
# 객체형 리스트 처리
1. class형태로 구조화된 내용을 list에 할당하여 다중의 객체형 리스트를 만드는 것잉다
2. 처리순서
    1) 구성할 class 선언
    2) list선언으로 객체를 생성하면서 할당하기
    3) for문을 통해서 해당 단위 객체 가져와서 처리하기
'''

class Product:
    def __int__(self, name, price):
        self.name = name
        self.price = price
    def buy(self, cnt):
            self.cnt = cnt
            print(self.name, end="\t")
            print(self.price, end="\t")
            print(self.cnt, end="\t")
            return self.price*self.cnt
import random as r 
buyList = []
buyList.append(Product("사과", 3000))        
buyList.append(Product("바나나", 4000))        
buyList.append(Product("딸기", 12000))   
tot=0
for prod in buyList:
    sum+=prod.buy(r.randrange(1, 6))
    print(sum)
    tot+=sum     
print("총비용:", tot)  

# ex) Student클래스르 ㄹ만들고 이름, 국어, 영어, 수학점수를 필드로 선언하고 
#     showRecord()메서드를 통해ㅓ 출력하고 평균점수를 리턴하여 출력하게 하ㅔ요
#     위 내용을 list에 할다앟고 학생 3명을 할당하고 출력하되 전체 평균을 출력하세요
class Student:
    def __int__(self, name, kor, eng, math):  
        self.name = name
        self.kor = kor
        self.eng = eng
        self.math = math
    def showRecord(self):
        print("학생이름: ", self.name, end="\t")
        print("국어점수: ", self.kor)
        print("영어점수: ", self.eng)
        print("수학점수: ", self.math)
        return (self.kor+self.eng+self.math)/3

stList = []
stList.append(Student("이지금", 100, 100, 100))               
stList.append(Student("이지은", 100, 100, 70))               
stList.append(Student("이지동", 80, 70, 100))  
avgTot= 0
for st in stList:
    avg = st.showRecord()
    print(int(avg))           
    avgTot += avg
print("전과목 전체 평균:", int(avgTot/len(stList)))            
            
            
            
            