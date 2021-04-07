import pandas as pd
import Statsmodels.formula.api as smf

df = pd.read_csv('survey.csv', encoding='cp949')

male = df.income[df.sex == 'm']
female = df.income[df.sex == 'f']

# Levene의 등분산 검정
l_result = stats.levene(male, female)

# 유의 수준 표시
if l_result[1] > .05:
    print('p_value는 %f 로 95% 수준에서 유의하지 않음' % l_result[1])
else:
    print('p_value는 %f 로 95% 수준에서 유의함' % l_result[1])

print( '남성', round(male.mean(),2), '여성',round(female.mean(),2),'\n등분산검정 결과 LeveneResult(F) : %.3f \np-value : %.3f' % (l_result))

# model = smf.ols(formula = 'jobsatisfaction ~ English', data=df)
# result = model.fit()

model = smf.ols(formula = 'jobsatisfaction ~ English+stress+income', data=df)
result = model.fit()
print(result.summary()) 

   
