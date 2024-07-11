import math
from collections import Counter

def createMultiset(string):
    multiset = []
    length = len(string)
    
    for i in range(length - 1):
        if string[i].isalpha() and string[i+1].isalpha():
            multiset.append(string[i:i+2])
    
    return multiset

def solution(str1, str2):
    str1_multiset = createMultiset(str1.lower())
    str2_multiset = createMultiset(str2.lower())
    
    if not str1_multiset and not str2_multiset:
        return 65536
    
    counter1 = Counter(str1_multiset)
    counter2 = Counter(str2_multiset)
    
    intersection = sum((counter1 & counter2).values())
    union = sum((counter1 | counter2).values())
    
    j_value = intersection / union
    return math.trunc(j_value * 65536)
