import pandas as pd

df = pd.read_csv('survey.csv', encoding='cp949')
# print(df.head())
# print(df.mean())
# print(df.income.mean())
# print(df.income.sum())
# print(df.income.median())    # 중간값
# print(df.describe())     # 계산할 수 있는 모든 통계값 출력
# std = 표준편차 / 25% = 0~25%의 표준편차(분포도에서)
# print(df.income.describe())     # Name: income, dtype: float64

# 빈도 분석 (어떤 데이터가 몇 번 나왔는지)
# print(df.sex.value_counts())

# # 같은 값을 가진 열끼리 그룹으로 묶임( groupby(그룹 나누는 변수).연산 )
# print(df.groupby('sex').mean())





# 싸이파이 패키지로 t검정하기 (통계의 결과가 의미있는지 확인하는 모듈)
# pip install scipy
from scipy import stats
# pvalue 값 : 유의확률값(0.05미만이거나, 0.01미만이면 유의미한 차이 존재)

male = df.income[df.sex == 'm']
female = df.income[df.sex == 'f']

ttest_result = stats.ttest_ind(male, female)
# print(ttest_result)
# print(ttest_result[1])    #pvalue=0.9161940781163369 이므로, 유의하지 않음

if ttest_result[1] > .05:
    print('p_value는',ttest_result[1],'로 95% 수준에서 유의하지 않음')
else:
    print('p_value는',ttest_result[1],'로 95% 수준에서 유의함')



# 피어슨/스피어만 상관관계 분석 (통계에서 두 변수가 얼마나 관련이 있는지?)
# 상관계수(r)이 도출됨.(-1부터 1 사이의 값.1과 -1에 가까울수록 관계가 높다.
# 0에 가까울수록 관계가 낮다.)
# corr(method = 'spearman') 함수를 통해 분석 가능/ method = 'spearman'안쓰면 피어슨 방식
corr = df.corr()
print(corr)
# income과 stress간의 상관관계를 출력
print(df.income.corr(df.stress))

# 분석의 결과물을 csv파일로 작성가능
corr.to_csv('corr.csv')




# 회귀 분석(상관관계 분석에서 파악할 수 없는 변수 사이의 인과관계)
# y(원인) = a + bx + e(오차)
# 영어점수와 직업만족도 사이 인과관계 분석
# Statsmodels 패키지 설치 & 임포트
