# 정규표현식으로 긴 문자열 다루기(import re)
#모든 한글범위 : r'\([A-Za-z가-힣])'
import re
example = '이동민 교수님은 다음과 같이 설명하셨습니다(이동민, 2019). 그런데 다른 교수님은 이 문제에 대해서 다른 견해 어쩌구(최재영, 2019). 또 다른 견해(Lion, 2018)'
result = re.findall(r'\([A-Za-z가-힣]+, \d+\)', example)
print(result)   #['(이동민, 2019)', '(최재영, 2019)', '(Lion, 2018)'] - list로 반환
result = re.findall(r'\(.+\)', example)
print(result)
result = re.findall(r'\(.+?\)', example)
print(result)

#re.match(패턴, 문자열) : 가장 처음부터 원하는 패턴의 문자열을 찾음. 대소문자 구분해 찾음
# 텍스트 중간에 있는 패턴은 찾지 못함
#group() : 매칭된 문자열 반환
pattern = r'good'   #패턴에는 r붙여주기
script = 'Life. my life is goodlife'
# print(re.match(pattern, script))
# print(  re.match(pattern, script).group()  )

# script 문자열에 pattern 문자열이 있는지 확인하는 함수
def refinder(pattern, script):
    if re.match(pattern, script):
        print("Match! :", re.match(pattern, script).group())
    else:
        print('Not a match...')
refinder(pattern, script)

# re.search(패턴, 문자열) : match와는 달리 모든 구간 검색. 
# 그러나 단어 앞부분만 검색가능.(goodlife의 life는 못찾음) 대소문자 구분
print(re.search(pattern, script))
print(re.search(pattern, script).group())

# re.findall(패턴, 문자열) : 찾지못해도 오류 대신 빈 문자열 반환
ex = 'my number is 210404-3****** and yours is 210303-4******'
print(re.findall(r'\d{6}', ex)) #생년월일만 구하기(숫자 6개)
# 문자열 greedy
example = '나는 96년도에 태어났고, 97년에는 IMF가 있었다. 지금은 2021년이다.'
print(re.findall(r'\d.+년', example))
#~~년에서 끊어주기 위해 ?를 사용한다. '년'이 나오면 패턴이 중지된다.
print(re.findall(r'\d.+?년', example))
print(re.findall(r'\d+.?년', example))

# re.split(패턴, 문자열) : 특정패턴이 나올때마다 문자열 분할
sentence = '   I love a lovely dog, really.     I am not telling a lie. what a pretty dog! I love this dog.'
# 구분자로 끝났기 때문에, 그 뒤에도 문자열이 있다고 인식해서 맨 마지막에 빈문자열 하나를 추가로 반환한다.
print(re.split(r'[.?!]', sentence) )  

data = 'a:3;b:4;c:5'
for i in re.split(r';', data):  #split으로 반환되는 배열에 반복문 걸기
    print(re.split(r':', i))

# re.sub(찾을 패턴, 대체할 문자, 문자열) : 문자를 대체하는 메소드
snake = re.sub(r'dog', 'snake', sentence)
print( snake )
# 공백 삭제용으로 사용가능
ssubb = re.sub(r'\s+', ' ', snake)
print( ssubb )
sentence = 'I love a lovely dog, really.\nI am not telling a lie.\nwhat a pretty dog!\nI love this dog.'
print( re.sub(r'\n', ' ', sentence) )

# ny로 끝나는 단어 찾기
print( re.findall(r'\w+ly', sentence))

