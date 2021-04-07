import os, re, usecsv

apt = usecsv.switch(usecsv.opencsv('apt_202102.csv'))
# print(apt[:3])
print(len(apt))
# 처음 5개의 원하는 자료 출력
'''
for i in apt[:6]:
    print(i[0], i[4], i[-4])

for i in apt:
    try:
        if re.match('강원', i[0]) and i[5] >= 120 and i[-5] <= 30000:
            print(i[0], i[4], i[5])
    except:
        pass
'''
price = []
newlist = []
for i in apt:
    try:
        #if i[5] >= 100 and i[-4]>10 and i[-4]<15  and i[-5] >= 50000:
        #if i[5]> 130 and i[-5]<= 40000:
        #if re.search(r'아이파크', i[4]):
        if i[-5] > 300000:
            newlist.append([i[0], i[4], i[5], i[-4], i[-5]])
            price.append(i[-5])
    except:
        pass

# 숫자관련 모듈 numpy import
import numpy as np  
price2 = np.array([price])  # list객체를 arraylist로 만들어준다.
print(price2.min(), price2.max())

usecsv.writecsv('apt_over300000.csv', newlist)
