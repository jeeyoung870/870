# pandas
# DataFrame() 함수를 사용하여 딕셔너리형 자료를 판다스로 가공 가능

import pandas as pd

data = {'name' : ['Mark', 'Jane', 'Chris', 'Ryan'],
'age' : [33,32,44,42],
'score' : [91.3, 83.4, 77.5, 87.7]}

df = pd.DataFrame(data)

# sum:합계 / mean(평균) / 딕셔너리처럼 우너하는 데이터 뽑기 가능
print(df.sum())
print(df.mean())
print(df.age)
print(df.age[2])    # 44