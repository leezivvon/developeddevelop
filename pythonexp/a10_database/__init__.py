'''
Created on 2023. 1. 3.

@author: LG



# DB연결과 조회 처리

0. 환경설정 path setting
    추가되는 모듈을 활용하기 위해서 
    
1. oracle연동 lib설정
    pip install cx_oracle
    import cx_oracle as oci
2. 연결 정보 처리
    oci.connect("계정/비번 @ip:port:sid")
3. 커서 가져오기
    conn.cursor()
4. sql명령문자열 선언
5. sql실행
    cursor.execute(sql)
    ==> 커서에 데이터가 담김
6. 실행된 결과 데이터 가져오기    
    cursor.fetchall() : 결과값이 2차원데이터일 때 튜플형 배열로 담김
    cursor.fetchone() : 결과값이 1차원 단일 데이터일 때 튜플현 단일데이터 담김
7. 데이터 출력하기
8. 커서 닫기 : cursor.close()
9. 연결 닫기 : conn.close()    

'''

import cx_Oracle as oci
conn = oci.connect("scott/tiger@localhost:1521/xe")
print("연결확인(version):", conn.version)
 # 1. pip 설치 확인
 # 2. path 설정 확인



