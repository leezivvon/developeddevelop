'''
Created on 2023. 1. 4.

@author: LG

# 등록/수정/삭제
1. CRUD에서는 연결객체에서 commit()기능 메서드가 수행된다
insert into emp01 values(7999, '마길동', '대리', 7902,to_date('2023-01-01', 'YYYY-MM-DD'), 3500, 100, 10)
commit;


'''
# 입력할 데이터 
empno = 7800
ename = '홍길동'
job = '사원'
mgr = 7999
hiredate='2023-01-01'
sal = 3000
comm = 200
deptno = 10

#sql작성
sql = '''
insert into emp01 values({}, '{}', '{}', {},to_date('{}', 'YYYY-MM-DD'), {}, {}, {})
'''.format(empno, ename, job, mgr, hiredate, sal,comm, deptno)

import cx_Oracle as oci
conn = oci.connect("scott/tiger@localhost:1521/xe")
print(conn.version)
cursor = conn.cursor()
cursor.execute(sql)
conn.commit()

#자원해제
cursor.close()
conn.close()
print("등록완료!")