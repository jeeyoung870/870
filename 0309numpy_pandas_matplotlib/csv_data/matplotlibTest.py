import matplotlib.pyplot as plt

# 맷플롯립으로 그래프 그리기 (show() 함수 사용)

# 모양에 들어갈 수 있는 글자들 : 
# '-','--','-.',':','.','o','v','^','<','3','4','s',p','*','h','H','+','x'
#  '>','1',2','_','D','d','|'

x = [1,4,9,16,25,36,49,64]
y = [i for i in range(1,9)]
plt.plot(x, color='r')
plt.plot(y, color='b')
plt.xlabel('x')
plt.ylabel('y')
plt.title("matplot sample")
plt.show()