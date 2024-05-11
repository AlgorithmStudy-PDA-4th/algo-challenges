def solution(clothes):
    answer=1
    data={}
    for cloth,types in clothes:
        data[types]=data.get(types,0)+1
        
    for d_v in data.values():
        answer*=d_v+1
        
    return answer-1