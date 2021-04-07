import os
print(os.getcwd())  #현재 경로 탐색
#경로 입력할때 앞에다 r을 붙이고 문자열 입력하면 \역슬래쉬를 특수기호로 인식하지 않음
#\\처럼 역슬래쉬 두개 써도 특수기호 인식 안됨
#경로 이동하기
os.chdir(r'C:\Users\Jiyoung\eclipse-workspace\Board\src\main\webapp\resources')   
print(os.getcwd())
print(os.listdir())     #경로안의 파일들을 list로 반환

os.chdir(r'C:\Users\Jiyoung\python\0304')
print(os.getcwd())

#파일 열기 -> 파일 객체 = open('파일명', '파일 열기 모드', 'charset-생략가능')
#open 함수로 여는 파일은 객체에 저장해야 함
#열기모드 : 
# 'w'=쓰기모드.해당파일명 없으면 경로에 새로 만들어줌.
# 'r'=파일내용을 읽을 때  
# 'a'=파일에 내용 추가하기 모드
#import codecs
f = open('a.txt', 'w', encoding='utf-8')
word = 'asdf한글한글'
print(f.write(word))    #선택한 파일에 내용을 넣고 글자수 반환
f.close()   #작업 끝낼때 닫아줘야 함
g = open('a.txt', 'r', encoding='utf-8')
print('첫번째 읽음 :', g.read()) #선택한 파일 읽기
g.close()
h = open('a.txt', 'a', encoding='utf-8')
print(h.write(' 기존 내용에 추가하기')) #텍스트 추가
h.close()
g = open('a.txt', 'r', encoding='utf-8')
print('두번째 읽음 :', g.read())

#with문 사용 : close 자동적용
# with open('파일명', '열기모드') as f(변수명):
    #f에 수행할 명령 - 들여쓰기 주의!
with open('a.txt', 'a', encoding='utf-8') as f:
    f.write('\nI love python. Really..')

#codecs 모듈 : encoding= 문 생략가능 / codecs.open으로 열기
import codecs
with codecs.open('a.txt', 'r', "utf-8") as f:
    print(f.read())



