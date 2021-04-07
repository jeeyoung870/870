import numpy as np
discount = .05  #할인률
cashflow = 100 # 현금 100억

# n년차 자본의 현재 가치(%)
def presentvalue(n):
    return (cashflow / ((1+discount) ** n))

#print(presentvalue(1))

# for i in range(20):
#     print(presentvalue(i))


# numpy로 사업성 계산하기
import numpy_financial as npf
#1~20년 연간수입(단위 억)
cf = [-750, -250, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100]
cashflow = np.array(cf) #배열로 만들기
# 순현재가치(npv)(할인률 4.5%), 내부수익률(irr) 구하기
print(npf.irr(cashflow))
print(npf.npv(0.045, cashflow))
# 20년후 현재 174억으로, 6.4%의 수익이 난다.