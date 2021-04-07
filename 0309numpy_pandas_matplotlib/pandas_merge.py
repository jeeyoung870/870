# concat 과 merge 사용하기
import pandas as pd
import numpy as np

df1 = pd.DataFrame({'A': ['A0', 'A1', 'A2', 'A3'], 
                    'B': ['B0', 'B1', 'B2', 'B3'],
                    'C': ['C0', 'C1', 'C2', 'C3'],
                    'D': ['D0', 'D1', 'D2', 'D3']},
                   index=[0, 1, 2, 3])

df2 = pd.DataFrame({'A': ['A4', 'A5', 'A6', 'A7'],
                    'B': ['B4', 'B5', 'B6', 'B7'],
                    'C': ['C4', 'C5', 'C6', 'C7'],
                    'D': ['D4', 'D5', 'D6', 'D7']},
                   index=[4, 5, 6, 7])

df3 = pd.DataFrame({'A': ['A8', 'A9', 'A10', 'A11'],
                    'B': ['B8', 'B9', 'B10', 'B11'],
                    'C': ['C8', 'C9', 'C10', 'C11'],
                    'D': ['D8', 'D9', 'D10', 'D11']},
                   index=[8, 9, 10, 11])

# print(df1)
# print(df2)
# print(df3)

# 열의 이름이 같다면, concat으로 열방향으로 dataframe을 합칠 수 있다.
# keys=['x', 'y', 'z'] => df1, df2, df3의 데이터에 각각 x,y,z 키가 붙는다.
result = pd.concat([df1, df2, df3], keys=['x', 'y', 'z'])
# print(result)
# print(result.index)


# 두 dataframe의 열의 이름이 다를경우
df4 = pd.DataFrame({'B': ['B2', 'B3', 'B6', 'B7'], 
                    'D': ['D2', 'D3', 'D6', 'D7'],
                    'F': ['F2', 'F3', 'F6', 'F7']},
                   index=[2, 3, 6, 7])

# 다른 index의 데이터들은 따로 합쳐지고, 해당하지 않으면 nan이 출력된다.
# result = pd.concat([df1, df4], axis=1)

# join='inner' : 공통되는 index만 합쳐서 출력한다.
# result = pd.concat([df1, df4], axis=1, join='inner')

# 열을 기준으로 합친다.(A, B, C, D, F)
result = pd.concat([df1, df4], ignore_index=True)
# print(result)




# merge 사용하기
left = pd.DataFrame({'key': ['K0', 'K4', 'K2', 'K3'],
                     'A': ['A0', 'A1', 'A2', 'A3'],
                     'B': ['B0', 'B1', 'B2', 'B3']})

right = pd.DataFrame({'key': ['K0', 'K1', 'K2', 'K3'],
                      'C': ['C0', 'C1', 'C2', 'C3'],
                      'D': ['D0', 'D1', 'D2', 'D3']})
# on= : 공통컬럼을 기준으로 합치되, 겹치지 않으면 빼고 출력
# print(pd.merge(left, right, on='key'))  
# how='inner'/ 'outer' / 'left' / 'right' 조건으로 합치기 가능
# print(pd.merge(left, right, how='inner', on='key'))  


