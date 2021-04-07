# csv파일 쓰기
import csv
a = [['구','전체','내국인','외국인'],
['관악구','509803','495060','14743'],
['강남구','544055','539231','4824'],
['송파구','673926','667960','5966'],
['강동구','463998','459970','4028']]

f = open('abc.csv', 'w', newline='', encoding='utf-8')
csvobject = csv.writer(f, delimiter= ',')
csvobject.writerows(a)
f.close()

# 파일 쓰는 함수 만들기
def writecsv(filename, the_list):
    with open(filename, 'w', newline='') as f:
        a = csv.writer(f, delimiter=',')
        a.writerows(the_list)