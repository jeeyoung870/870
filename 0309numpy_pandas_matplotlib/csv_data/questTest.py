import usecsv
import numpy as np

quest = np.array(usecsv.switch(usecsv.opencsv('quest.csv'))) #switch: 숫자를 float로 변환
# print(quest)
#print(quest>5)  # 5보다 큰지 원소 하나하나 boolean출력
# 5보다 큰 원소는 5로 바꿔주기
quest[quest > 5] = 5
print(quest)

#바꾼 결과물 파일로 저장하기(list로 바꿔서 저장해줘야함)
quest = quest.astype('int32')   #float를 int32로 변환
usecsv.writecsv('questresult.csv', list(quest))