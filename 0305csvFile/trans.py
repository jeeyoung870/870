import re, os, usecsv

English = 'She is a vegetarian. She does not eat meat. She thinks that animals should not be killed. It is hard for her to hang out with people. Many people like to eat meat. She told his parents not to have meat. They laughed at her. She realized they couldn\'t give up meat.'
Korean = '그녀는 채식주의 자입니다. 그녀는 고기를 먹지 않습니다. 그녀는 동물을 죽이면 안된다고 생각합니다. 그녀가 사람들과 어울리는 것은 어렵습니다. 많은 사람들이 고기를 좋아합니다. 그녀는 부모에게 고기를 먹지 말라고 말했습니다. 그들은 그녀를 비웃었습니다. 그녀는 그들이 고기를 포기할 수 없다는 것을 깨달았습니다.'

Korean_list = re.split(r'\.', Korean)
English_list = re.split(r'\.', English)

print(Korean_list[0])

total = []
for i in range(len(English_list)):
    total.append([English_list[i], Korean_list[i], '\n'])

usecsv.writecsv('trans.csv', total)