import os, re, codecs
os.chdir(r'C:\Users\Jiyoung\python\0304')

with codecs.open('friends101.txt', 'r', 'utf-8') as script:
    # readlines() : 배열로 읽어옴
    sentences = script.readlines()
     # 앞에 3줄만 출력하기
    print(sentences[:3])

#200줄 중에서 대사에 'would'가 있는 것만 출력하기
for i in sentences[:200]:
    if re.match(r'[A-Z][a-z]+:', i) and re.search(r'would', i):
        print(i)

take = [i for i in sentences if re.match(r'[A-Z][a-z]+:', i) and re.search(r'take', i)]
with codecs.open('take.txt', 'w', 'utf-8') as ff:   
    # readlines() <-> writelines() : 한 줄씩 출력
    ff.writelines(take)