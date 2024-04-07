import collections

def solution(nums):
    answer = 0
    num_dict = collections.Counter(nums)
    if len(num_dict) >= (len(nums)/2):
        answer = len(nums)/2
    else:
        answer = len(num_dict)
    return answer
