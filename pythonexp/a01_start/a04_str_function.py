'''
Created on 2022. 12. 21.

@author: LG
'''


'''
# 문자열 관련 함수
1. len()
    1) 문자열의 길이를 파악할 때 사용한다
        len(문자열) : 문자열의 길이
    2) 한글, 기호, 영문, 공백, 숫자가지 모두 글자로 취급한다
2. upper(), lower()
    1) 대문자, 소문자 변환 처리를 해준다
        문자열.upper()/문자열.lower()
3. isupper(), islower()
    1) bool(True/False)로 모두 대문자인지 모두 소문자인지 확인
4. count()
    1) 문자열에서 어떤 글자가 몇 번 등장하는지 확인한다
    2) 형식
        문자열.count("개수확인할 문자")
5. find()
    1) 어떤 글자가 문자열의 몇 번째에 위치하는지 찾음
    2) 해당 문자열이 있으면 해당하는 문자가 시작하는 index(0번부터)를 리턴한다
       없으면 -1이 리턴된다
    3) 형식
        문자열.find("찾을 문자열") : 처음부터 찾음
        문자열.find("찾을 문자열", 시작index) : 특정 index 시작 위치부터 찾음
'''

print("Hello".upper())
print("Hello".lower())
print("Don't dwell on the path".isupper())
print("believe in yourself".islower())
sen01='''난생 처음 파이썬을 처음으로 학습중입니다!
파이썬은 처음이지만 재밌는것 같네용
처음이 중요하죠^^*'''
print(sen01.count("처음"))    #4
print(sen01.find("처음"))     #3
print(sen01.find("처음",10)) #11

# ex1) 영어 격언을 찾아서 대문자/소문자로 변환해서 출력하세요
adge = "nothing seek, nothing find"
print(adge.upper())
print(adge.lower())
# ex2) 위키백과에서 빅데이터를 검색해서 ''' '''안에 붙여넣고 가장 많이 보이는 단어의 개수 확인
# ex3) 위 내용의 단어가 두번째로 나오는 위치 리턴
line01 = '''﻿I love my boy I love my boy I love my boy I love my boy Everybody scream
오늘 밤 내일 밤 자꾸만 니 생각나 나는 그대의 Diva diva di di di diva 오늘 밤 내일 밤 짜릿 짜릿한 이순간 나는 그대의 Diva diva di di di diva
자꾸만 니 생각에 난 너의 달콤한 향기 아무렇지 않은 척 난 네게 빠져버렸어 차갑게 말을 안해도 나는 멈출 수 없어 날 바라 본다고 약속해 내게
I got 니 맘을 열 수 있는 Master key 넌 나의 Master piece 우리 같이 마치 환상의 tatting You know
we\'re destiney 사랑은 불 타 After this 너무나 달콤한 속삭임 짜릿짜릿한 계속 Swing boy You\'re my favorite
오늘 밤 내일 밤 자꾸만 니 생각나 나는 그대의 Diva diva di di di diva 오늘 밤 내일 밤 짜릿 짜릿한 이순간 나는 그대의 Diva diva di di di diva 
Let\'s tell me what you wanna do 내 맘 너 가져가라고 I don\'t wanna let you go 너 나만 바라보라고
I just wanna get it done 사랑을 말 할꺼라고 아파도 좋아 니가 없이는 살 수가 없어
I got think dance for you Love for you I don\'t give up tell what people say 사랑이 중요해 No matter What you want my man
자꾸만 점 점 난 먼저 L O V E 사랑이란 감정 You\'re so perfect 넌 내게 만점 Come to me
내게 다가와줘 오늘 밤 내일 밤 자꾸만 니 생각나 나는 그대의 Diva diva di di di diva 오늘 밤 내일 밤 짜릿 짜릿한 이순간 나는 그대의 Diva diva di di di diva
오늘 밤 니곁에서 잠들고만 싶어 이런게 사랑일까 자꾸만 떨려 따뜻한 너의 품에 안기고만 싶어 나 이제 어떡해 너에게 빠졌나봐
오늘 밤 내일 밤 자꾸만 니 생각나 나는 그대의 Diva diva di di di diva 오늘 밤 내일 밤 짜릿 짜릿한 이순간 나는 그대의 Diva diva di di di diva
오늘 밤 내일 밤 자꾸만 니 생각나 나는 그대의 Diva diva di di di diva 오늘 밤 내일 밤 짜릿 짜릿한 이순간 나는 그대의 Diva diva di di di diva 
난 난 난 나 나 난 난 난 나 나 난 난 난 나 나 난 난 난 나 나 Diva diva di di di diva'''
print("데이터 검색: ",line01.count("diva"))
print("첫번째 데이터 위치: ",line01.find("diva"))
print("두번째 데이터 위치: ",line01.find("diva",180))




