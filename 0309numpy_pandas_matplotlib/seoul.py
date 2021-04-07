
# CCTV_in_Seoul : 서울시의 구별 cctv갯수
# read_excel 하기 위해서는 Script경로에 pip install xlrd 이 필요함.
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
# 그래프, 한글처리 글꼴 위한 import 
import platform
from matplotlib import font_manager, rc


CCTV_Seoul = pd.read_csv('CCTV_in_Seoul.csv',  encoding='utf-8')
#print(CCTV_Seoul.head())
pop_Seoul = pd.read_excel('population_in_Seoul.xls')
# print(pop_Seoul.head())

pop_Seoul = pd.read_excel('population_in_Seoul.xls', 
                          header = 2,           # 2번인덱스까지 header로 쓴다 = 데이터는 3번인덱스부터 읽어온다
                          usecols = 'B, D, G, J, N',)       #xls파일 맨 상단의 col이름
# usecols에 지정한 컬럼들을 각각 rename
# inplace=True :  기존에 있던 데이터프레임에 적용시킬것인지 - true
pop_Seoul.rename(columns={pop_Seoul.columns[0] : '구별', 
                          pop_Seoul.columns[1] : '인구수', 
                          pop_Seoul.columns[2] : '한국인', 
                          pop_Seoul.columns[3] : '외국인', 
                          pop_Seoul.columns[4] : '고령자'}, inplace=True)
# print(pop_Seoul.head())


# print(CCTV_Seoul.sort_values(by='소계', ascending=False).head())

CCTV_Seoul['최근증가율'] = (CCTV_Seoul['2016년'] + CCTV_Seoul['2015년'] + \
                        CCTV_Seoul['2014년']) / CCTV_Seoul['2013년도 이전']  * 100
# print(CCTV_Seoul.sort_values(by='최근증가율', ascending=False).head())


# 데이터 삭제
pop_Seoul.drop([0], inplace=True)   # 0번째index의 합계 열 삭제
print(pop_Seoul.head())

# unique() :  반복데이터 제외하고 출력
# print(pop_Seoul['구별'].unique())
# 맨 마지막의 nan데이터는 지워준다.
# print(pop_Seoul[pop_Seoul['구별'].isnull()])     # nan인 열(인덱스)찾기
pop_Seoul.drop([26], inplace=True)      # nan인 열 삭제하기
print(pop_Seoul['구별'].unique())


# 새 컬럼 추가하기
pop_Seoul['외국인비율'] = pop_Seoul['외국인'] / pop_Seoul['인구수'] * 100
pop_Seoul['고령자비율'] = pop_Seoul['고령자'] / pop_Seoul['인구수'] * 100
# print(pop_Seoul.head())

# 컬럼명을 pop_Seoul의 구별과 똑같이 바꾸기
CCTV_Seoul.rename(columns={CCTV_Seoul.columns[0] : '구별'}, inplace=True)
# print(CCTV_Seoul.head())

# '구별'을 공통분모로 data합치기
data_result = pd.merge(CCTV_Seoul, pop_Seoul, on='구별')
# print(data_result)

del data_result['2013년도 이전']
del data_result['2014년']
del data_result['2015년']
del data_result['2016년']


# 구별 의 값들을 index로 사용하겠다.
data_result.set_index('구별', inplace=True)
# print(data_result.head())




# 인구와 cctv의 상관계수 구하기 (np.corrcoef() 메소드 사용)
# 상관계수 : 0.1이하면 무시, 0.3~ 약한 상관관계, 0.7~뚜렷한 상관관계
# print(np.corrcoef(data_result['고령자비율'], data_result['소계']))
# print(np.corrcoef(data_result['외국인비율'], data_result['소계']))
# print(np.corrcoef(data_result['인구수'], data_result['소계']))

# sort_values : 많은 순서대로 
print(data_result.sort_values(by='소계', ascending=False).head(5))
print(data_result.sort_values(by='인구수', ascending=False).head(5))



# 그래프 한글처리 (복붙사용)
plt.rcParams['axes.unicode_minus'] = False

if platform.system() == 'Darwin':
    rc('font', family='AppleGothic')
elif platform.system() == 'Windows':
    path = "c:/Windows/Fonts/malgun.ttf"
    font_name = font_manager.FontProperties(fname=path).get_name()
    rc('font', family=font_name)
else:
    print('Unknown system... sorry~~~~')


# 각 구별 CCTV개수
# data_result['소계'].sort_values().plot(kind='barh', grid=True, figsize=(10,10))
# # plt.show()

plt.figure()
data_result['CCTV비율'] = data_result['소계'] / data_result['인구수'] * 100
# data_result['CCTV비율'].sort_values().plot(kind='barh', grid=True, figsize = (10, 10))

# polyfit :  인구와 cctv의 상관계수를 직선으로 그려줌
fp1 = np.polyfit(data_result['인구수'], data_result['소계'], 1)
fx = np.linspace(100000, 700000, 100)   #x축
f1 = np.poly1d(fp1)     # y축


plt.scatter(data_result['인구수'], data_result['소계'], s=50)
plt.plot(fx, f1(fx), ls='dashed', lw=3, color='g')
plt.xlabel('인구수')
plt.ylabel('CCTV')
plt.grid()
plt.show()

plt.show()
