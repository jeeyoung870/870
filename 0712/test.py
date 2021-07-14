# -*- coding: utf-8 -*-
# If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
# The sum of these multiples is 23.
# Finish the solution so that it returns the sum of all 
# the multiples of 3 or 5 below the number passed in.
def solution(number):
    sum = 0
    for i in range(1, number):
        if i%3 == 0 or i%5 == 0:
            print(i)
            sum += i
    return sum
print(solution(10))


# sends you an array of one-letter strings representing directions 
# to walk (eg. ['n', 's', 'w', 'e']). You always walk only a single block 
# for each letter (direction) and you know it takes you one minute 
# # to traverse one city block
# create a function that will return true if the walk the app gives 
# you will take you exactly ten minutes, Return false otherwise.
def is_valid_walk(walk):
    #determine if walk is valid
    if len(walk) != 10:
        return False
    dir = ['n', 's', 'w', 'e']
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    nowx = 0
    nowy = 0
    for i in walk:
        nowx += dx[dir.index(i)]
        nowy += dy[dir.index(i)]
    if nowx == 0 and nowy == 0:
        return True
    return False
print(is_valid_walk(['n','s','n','s','n','s','n','s','n','s']))


# return highest and lowset
def high_and_low(numbers):
    nums = list(map(int, numbers.split()))
    high = str(max(nums))
    low = str(min(nums))
    numbers = high + ' ' + low
    return numbers
print(high_and_low('4 5 29 54 4 0 -214 542 -64 1 -3 6 -6'))


# friends = exactly 4 letters
def friend(x):
    #Code
    friends = []
    for i in x:
        if len(i) == 4:
            friends.append(i)
    return friends
print(friend(["Ryan", "Jimmy", "123", "4", "Cool Man"]))



#persistence(39) # returns 3, because 3*9=27, 2*7=14, 1*4=4
                 # and 4 has only one digit          
#persistence(999) # returns 4, because 9*9*9=729, 7*2*9=126,
                  # 1*2*6=12, and finally 1*2=2
#persistence(4) # returns 0, because 4 is already a one-digit number
def persistence(n):
    # your code
    if len(str(n)) <= 1:
        return 0
    count = 0
    num = n
    while True:
        count += 1
        temp = 1
        for i in str(num):
            temp *= int(i)
        if len(str(temp)) > 1:
            num = temp
        else:
            break
    return count
print(persistence(999))


# Who likes it?
def likes(names):
    # your code here
    if len(names) == 0:
        return 'no one likes this'
    elif len(names) == 1:
        return names[0] + ' likes this'
    elif len(names) == 2:
        return names[0]+' and '+names[1]+' like this'
    elif len(names) == 3:
        return names[0]+', '+names[1]+' and '+names[2]+' like this'
    else:
        otherP = str(len(names) - 2)
        return names[0]+', '+names[1]+' and '+otherP+' others like this'
    pass


# Find The Parity Outlier(혼자 홀수거나 혼자 짝수인 수 찾기)
def find_outlier(integers):
    even = []
    odd = []
    for i in integers:
        if i%2 == 0:
            even.append(i)
        else:
            odd.append(i)
    if len(odd) > len(even):
        return even[0]
    return odd[0]
print(find_outlier([2, 4, 0, 100, 4, 11, 2602, 36]))


# Complementary DNA (A - T, G - C)
def DNA_strand(dna):
    # code here
    output = ''
    for i in dna:
        if i == 'A':
            output += 'T'
        elif i == 'T':
            output += 'A'
        elif i == 'G':
            output += 'C'
        elif i == 'C':
            output += 'G'
    return output
def DNA_strand2(dna):
    pairs = {'A':'T', 'T':'A', 'G':'C', 'C':'G'}
    out = ''
    for x in dna:
        out += pairs[x]
    return out
print(DNA_strand2('ATTGAGC'))



# Two to One (철자 한 번씩만 들어가는 가장 긴 문자열 만들기)
def longest(a1, a2):
    # your code
    sumstr = ''
    for i in a1, a2:
        for j in i:
            if j not in sumstr:
                sumstr += j
    sortstr = sorted(sumstr)
    out = ''.join(sortstr)
    return out
# print(longest("aretheyhere", "yestheyarehere"))

def longest2(a1, a2):
    return ''.join(sorted(set(a1 + a2)))
print(longest2("aretheyhere", "yestheyarehere"))



# Get the Middle Character
def get_middle(s):
    #your code here
    if len(s) <= 1:
        return s
    elif len(s)%2 == 0:
        return s[len(s)//2-1] + s[len(s)//2]
    else:
        return s[len(s)//2]
def get_middle2(s):
    return s[(len(s)-1)//2:len(s)//2+1]
print(get_middle2('chart'))


# Does my number look big in this?
# For example, take 153 (3 digits), which is narcisstic:
#     1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
# and 1652 (4 digits), which isn't:
#     1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938
def narcissistic( value ):
    # Code away
    digit = len(str(value))
    sum = 0
    for i in list(str(value)):
        sum += int(i)**digit
    return  value == sum
print(narcissistic(371))


# Decode the Morse code
def decodeMorse(morse_code):
    # ToDo: Accept dots, dashes and spaces, return human-readable message
    if len(morse_code) == 0:
        return morse_code
    else:
        out = ''
        space = ' '
        words = morse_code.split(space * 3)
        for i in range(len(words)):
            letter = words[i].split(space)
            for j in letter:
                out += MORSE_CODE[j]
            if i != len(words)-1:
                out += space
        return out


# Dubstep

