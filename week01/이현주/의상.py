def solution(clothes):
    answer = 1
    clothes_dict = {}
    for cloth in clothes:
        clothes_dict[cloth[1]] = clothes_dict.get(cloth[1], 1) + 1
    
    for v in clothes_dict.values():
        answer *= v
        
    return answer - 1
