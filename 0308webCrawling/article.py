# 다음뉴스(https://news.daum.net/)에서 머리기사 정보 모으기
import os, re, usecsv
import urllib.request as ur
from bs4 import BeautifulSoup as bs

news = 'https://news.daum.net/'
soup = bs(ur.urlopen(news).read(), 'html.parser')

# 사이트 내용에서 첫번째 머리기사의 href를 찾아 해당 주소의 내용을 html.parser하고, 
# div태그 중news_view클래스만 출력하기
f = open('article.txt', 'w', encoding='utf-8')
for i in soup.find_all('div', {'class':'item_issue'}):
    try:
        f.write(i.text+'\n')
        f.write(i.find_all('a')[0].get('href')+'\n')
        soup2 = bs(ur.urlopen(i.find_all('a')[0].get('href')).read(), 'html.parser')
        for j in soup2.find_all('div', {'class':'news_view'}):
            f.write(j.text)
    except:
        pass
f.close()

# print(soup.find_all('div', {'class':'cont_thumb'}))[0].text
'''
for i in soup.find_all('div', {'class':'cont_thumb'}):
    print(i.text)
'''
#get()함수로 속성 얻기 a.get('속성')
# a 태그의 href속성 가져오기
a = soup.find_all('a')[:5]
'''
for i in a:
    print(i.get('href'))
'''
for i in soup.find_all('div', {'class':'cont_thumb'}):
    print(i.find_all('a')[0].get('href'))


