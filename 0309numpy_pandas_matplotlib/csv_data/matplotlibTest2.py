import matplotlib.pyplot as plt
import numpy as np

# 0부터 12사이의 값을 0.01간격으로 가져와 배열로만듬
t = np.arange(0,12,0.01)    
y = np.sin(t)

# plot : 선 그래프
# plt.plot(t, y, lw=3, label='sin')   # lw : 그래프 굵기
# plt.plot(t, np.cos(t),'r', label='cos')
# plt.grid()
# plt.legend()    # 설명
# plt.xlabel('time')      # x축에 라벨(이름)적용
# plt.ylabel('Amplitude')
# plt.title('Example of sinewave')
# # plt.show()


t = np.array([0,1,2,3,4,5,6,7,8,9])
y = np.array([9,8,7,6,8,4,3,1,2,5])
colormap = t
# plt.figure(figsize=(10,6))
# # scatter : 점 찍어주는 그래프
# # plt.scatter(t,y, s=50, c=colormap, marker='>')
# # plt.colorbar()
# # plt.show()


s1 = np.random.normal(loc=0, scale=1, size=1000)
s2 = np.random.normal(loc=5, scale=0.5, size=1000)
s3 = np.random.normal(loc=10, scale=2, size=1000)

# plt.plot(s1, label='s1')
# plt.plot(s2, label='s2')
# plt.plot(s3, label='s3')
# plt.legend()
# plt.show()

# 박스 모양의 그래프 만들기
# 표준편차에 맞게 최대값, 최솟값, 범위를 그려줌
plt.boxplot((s1, s2, s3))
plt.grid()
plt.show()