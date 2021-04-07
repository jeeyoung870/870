import numpy as np

a = np.array([[2, 3], [5, 2]])
print(a)
print(type(a))  #<class 'numpy.ndarray'>

d = np.array([[1,2,3,4,5], [2,4,5,6,7], [5,7,8,9,9]])
'''
print(d)
print(d[1][2])
print(d[1,2])
'''
# 위와같은 다차원배열. 1번인덱스부터 끝까지, 그 요소의 3번인덱스부터 끝까지
print(d[1:, 3:])  
print(d[:2, :3])  

# 배열의 크기 알아내기 (shape)배열의 행과 열을 튜플()로 반환
print(d.shape)  #(3, 5) : 1차원배열의 갯수, 2차원배열의 갯수

# 배열의 원소타입 반환(dtype)
print(d.dtype)
# 배열 원소의 타입 변환(astype)
data = np.arange(1, 5)  # [1 2 3 4]1부터 5앞까지 배열로 만들어줌
print(data)
b = data.astype('float64')
# print(b)
# print(data)

# # 0으로 이뤄진 배열 만들기
# z = np.zeros( (2, 10) )
# print(z)
# print(z.dtype)  #float64
# # 1로 이뤄진 배열 만들기
# o = np.ones((3, 10))
# print(o)
# print(o.dtype)  #float64
# # 연속형 정수 배열 만들기
# c = np.arange(2, 10)
# print(c)

# 배열의 행과 열 바꾸기(transpose)
a = np.ones((2,3))
print(a)
# b = np.transpose(a)
# print(b)
dd = [[1,2,3],[4,5,6]]
e = np.transpose(dd)
#print(e)



# 배열의 사칙 연산
arr1 = np.array([[2,3,4], [6,7,8]])
arr2 = np.array([[12,23,14], [36,47,58]])
# 배열의 같은 자리의 원소끼리 연산한다.
print(arr1+arr2)    # [[14 26 18],[42 54 66]]
print(arr1 * arr2)
print(arr1 - arr2)
print(arr1 / arr2)

arr3 = np.array([100,200,300])
print(arr3.shape)
# 배열의 크기가 달라도 원소갯수가 겹치는 부분이 있다면 알아서 계산해줌
print(arr1 + arr3)  
arr4 = np.array([1,2,3,4,5,6,7,8,9,10])
# print(arr1 + arr4)  # 겹치는 부분이 없으면 에러가 발생해서 연산 못함.
# 행이나 열 중 한 가지는 일치해야 연산 가능
arr5 = np.array([[9], [3]])
print(arr1 + arr5)


# !! 파이썬 리스트와 배열의 차이점 !!
d = np.array([[1,2,3,4,5], [2,3,5,6,7], [5,7,8,9,9]])  #배열
d_list = [[1,2,3,4,5], [2,3,5,6,7], [5,7,8,9,9]]    #list
# d_list[:2] = 0      # 한 번에 데이터 바꾸려 하면 에러 발생
d[:2] = 0
print(d)    # 1번 인덱스까지의 모든 데이터가 0으로 변경됨
# 대량의 데이터를 한번에 바꾸기에는 배열이 유리함

arr6 = np.arange(10)  # 0~9
print(arr6)
print(arr6[:4])
print(arr6[-3:])

print(arr1[1,2])
print(arr1[:,2])    # 모든 1차원 배열에서 2번 인덱스를 배열로 반환



