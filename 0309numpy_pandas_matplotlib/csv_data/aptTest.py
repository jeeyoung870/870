import pandas as pd

#pandas로 csv파일 읽어와서 dataFrame으로 저장할 수 있다
# colum명이 각각 key고, 안의 데이터들이 value가 된다.
# pandas로 읽어 올때는 cp949 인고딩을 사용한다.
df = pd.read_csv('apt.csv', encoding='cp949')

print(len(df))

#데이터프레임 살펴보기
# head() = 맨앞 5개데이터만, tail() = 맨뒤 5개데이터만 꺼내옴
# print(df.head())
# print(df.tail())
 # 해당 조건에 맞는 데이터의 특정 열만 뽑아온다.
# print(df.아파트[df.면적 > 200])   

# print(df.아파트[(df.면적 > 130) & (df.가격 < 15000)])

# 정교한 조건 추가 = .loc[원하는 행의 조건, 열의 조건]
# print(df.loc[:, ['아파트', '가격']] [df.가격 > 40000])

# 값 추가하기 df['새/기존 열이름'] = 넣을 값
df['단가'] = df.가격 / df.면적
# print(df.loc[:10, ['아파트', '가격', '단가']])

# 데이터 정렬 sort_values(by = '열이름')
# 기본은 ascending, ascending = False로 내림차순 설정 가능
# print(df.sort_values(by = '가격').loc[:, ('가격', '지역')]) 
# print(df.sort_values(by = '가격', ascending = False).loc[:, ('가격', '지역')])

print(df[df.가격 >250000].sort_values(by='면적').loc[:, ['가격', '면적', '지역']])

# 특정 문자 포함 열 찾기 
# df.검색할 열.str.find('찾는 문자열') = 해당 열의 index를 반환한다.
df.지역.str.find('강릉') # 문자열이 없다면 -1 반환
# 분당 문자열을 포함하는 열 찾기
dfF = df[df.지역.str.find('분당') > -1]
print(dfF.mean())   # 찾은 모든 열의 평균
print(df.describe()) # 표에 대한 모든 정보값 출력

