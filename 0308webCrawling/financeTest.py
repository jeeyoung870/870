# 네이버 금융(https://finance.naver.com/)에서 10초마다 갱신되는 주가 정보 가져오기
# https://finance.naver.com/item/main.nhn?code=company_code

from bs4 import BeautifulSoup
from datetime import datetime
import requests
import time

# company_code에 해당하는 주가url을 html로 반환
def get_code(company_code):
    url = 'https://finance.naver.com/item/main.nhn?code=' + company_code
    result = requests.get(url)
    bs_obj = BeautifulSoup(result.content, 'html.parser')
    return bs_obj
# 주가화면에서 
def get_price(company_code):
    bs_obj = get_code(company_code)
    no_today = bs_obj.find('p', {'class':'no_today'})
    blind = no_today.find('span', {'class':'blind'})
    now_price = blind.text
    return now_price

# 주가를 찾을 종목 코드
company_codes = ['005930', '024810', '000660']

# 10초마다 주가 출력
while True:
    now = datetime.now()
    print(now)
    for item in company_codes:
        now_price = get_price(item)
        print(now_price)
    print('----------------------')
    time.sleep(10)