# 프렌즈 드라마 대본 텍스트 파일 가공하기
import os, re, codecs
os.chdir(r'C:\Users\Jiyoung\python\0304')
print(os.getcwd())
with codecs.open('friends101.txt', 'r', 'utf-8') as script:
    scr = script.read()
    print(scr[:100])
    #Monica의 대사 찾기(줄바꿈 전까지)
    line = re.findall(r'Monica:.+', scr)
'''
for i in line[:3]:
    print(i)
'''
with codecs.open('monica.txt', 'w', 'utf-8') as f:
    monica = ''     # string으로 지정
    for i in line:
        monica += i+'\n\n'
    f.write(monica)

#등장인물 리스트 만들기
char = re.compile(r'[A-Z][a-z]+:')  #compile : 정규표현식 객체로 저장하기
# print(re.findall(char, scr) )   # 대사 갯수만큼 출럭됨
# set으로 중복 없애기
print( set(re.findall(char, scr)) )

# 콜론 :  까지 떼기
colon = set(re.findall(char, scr))
names = list(colon)     # list로 만들어줘야 함
print(names)
for x in names:
    print(x[:-1])

# 지문만 출력하기(괄호안에 들어있는것 이용)
# .+ : 숫자,문자,빈칸이 자유롭게 반복됨 / [a-z|\.] : 마지막 글자로 영어소문자 또는 마침표가 옴
pattern = re.compile(r'\([A-Za-z].+[a-z|\.]\)')
acts = re.findall(pattern, scr)
act = list(acts)
for i in range(0, 6):
    print(act[i])