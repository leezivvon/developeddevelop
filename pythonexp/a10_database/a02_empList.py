'''
Created on 2023. 1. 4.

@author: LG



# ex) a02_empList.py를 만들어서 사원 정보 리스트를 출력
'''

import cx_Oracle as oci

conn=oci.connect("scott/tiger@localhost:1521/xe")
if conn !=None:
    print("연결성공! 버전", conn.version)

ename=input("검색할 사원명(키워드입력)_")
cursor = conn.cursor()
sql="""
select * 
from emp 
where ename like '%'||'{}'||'%' 
""".format(ename)
cursor.execute(sql)

#4.결과값튜플형식으로 가져오기 //튜플형식은 읽기전용
empDup = cursor.fetchall()
empList=[]
#5.반목문통해 출력
for emp in empDup:
    empList.append(list(emp)) # 튜플은 빠르지만 읽기만 가능 ==> 리스트(읽기/쓰기 가능한 형식)로 담아서
    print(emp[0], "\t", emp[1], "\t", emp[2],"\t",emp[3],"\t",emp[4],"\t",emp[5],"\t",emp[6],"\t",emp[7])  
    print("{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}".format(emp[0],emp[1], emp[2],emp[3],emp[4],emp[5],emp[6],emp[7])) 
print(empList)





