import csv, os, re

# csv열기
def opencsv(filename):
    f = open(filename, 'r')
    reader = csv.reader(f)
    output = []
    for i in reader:
        output.append(i)
    return output
# csv쓰기
def writecsv(filename, the_list):
    with open(filename, 'w', newline='') as f:
        a = csv.writer(f, delimiter=',')
        a.writerows(the_list)

# 콤마 떼주는 함수
def switch(listName):
    for i in listName:
        for j in i:
            try:
                # 쉼표를 ''로 대체(없앰)
                i[i.index(j)] = float(re.sub(',', '', j))
            except:
                pass
    return listName
