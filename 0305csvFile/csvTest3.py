# C:\Users\Jiyoung\AppData\Local\Programs\Python\Python39\Lib (파이썬 설치경로의 Lib)
# 경로에 붙여넣기한 usecsv.py파일을 import하여 안에 만든 함수 사용
import usecsv, re, os

a = [['국어', '영어', '수학'], [100, 99, 88]]

usecsv.writecsv('test.csv', a)

# 문자열과 숫자 구분해서 캐스팅한후, 원래 배열에 넣기
i = ['123!!', '151,767', '11,063', '27,384', '']
'''
for j in i:
    # 문자열과 !이 포함된 요소는 그대로 원래 list에 저장하고,
    if re.search('[A-Za-z가-힣!]', j):
        # i.index(j) = j를 요소로 가지는 i의 인덱스 구하기
        i[i.index(j)] = j
    else:
        # 숫자인 요소는 쉼표를 제거하고 float로 캐스팅해서 원래의 list에 저장한다.
        i[i.index(j)] = (float(re.sub(',', '', j)))
print(i)'''
# 하지만 이 방법은 ''(빈 문자열)요소가 있을 때 오류 발생한다.
# try - catch문으로 해결해야 함
for j in i:
            try:
                i[i.index(j)] = float(re.sub(',', '', j))
            except:  # 요소를 float로 캐스팅하는중에 예외가 발생한다면,(문자 혹은 빈칸)
                pass    #아무 처리 없이 넘어가라
print(i)


# popSeoul.csv파일 다루기
os.chdir(r'C:\Users\Jiyoung\python\0305')
total = usecsv.opencsv('popSeoul.csv')
newPop = usecsv.switch(total)
newPop[3][0] = 'Junggu'
usecsv.writecsv('popSeoul.csv',newPop)
# print(newPop[:4])

# 외국인 비율이 3%넘는 구 정보만 csv로 저장하기
new = [['구', '한국인', '외국인', '외국인 비율(%)']]    #첫번째줄로 들어갈 내용
for i in newPop:
    foreigner = 0
    try:
        # 외국인 비율(%) 구하기
        foreigner = round(i[2]/(i[1]+i[2])*100, 1)
        if foreigner > 3:
            new.append([i[0], i[1], i[2], foreigner])
            #print(i[0], foreigner)
    except:
        pass

usecsv.writecsv('foreigner.csv', new)