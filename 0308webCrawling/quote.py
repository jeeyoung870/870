# 명언 사이트(https://quotes.toscrape.com/)에서 명언 출력하기
# 뷰티풀수프 설치하기(html, xml을 다루는 프로그램)
# cmd에서 파이썬 설치경로의 Script폴더로 이동한후, 
# python -m pip install --upgrade pip
# pip3 install beautifulsoup4
# 설치한다.

import os, re, usecsv
# urllib : 웹에서 얻은 데이터를 다루는 패키지
# request : 웹문서를 열어 데이터를 읽어오는 모듈
import urllib.request as ur
from bs4 import BeautifulSoup as bs

# urlopen으로 웹사이트 정보 가져오기
url = 'https://quotes.toscrape.com/'
html = ur.urlopen(url)
# print(html.read()[:100])    # 열린 url의 html을 읽어오기

# 읽어온 데이터를 뷰티풀수프로 읽기 쉬운 html.parser형태로 변환하기
soup = bs(html.read(), 'html.parser')
print(type(html))   # <class 'http.client.HTTPResponse'>
print(type(soup))   # <class 'bs4.BeautifulSoup'>

# 특정 태그 첫번째에서 텍스트만 추출하기(find_all) -> quote[0].text
print(soup.find_all('span')[0].text)
# span 태그중 class속성값이 text인 텍스트만 출력하기
for i in soup.find_all('span', {'class':'text'}):
    print(i.text)
