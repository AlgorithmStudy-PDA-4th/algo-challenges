def solution(participant, completion):
    participant = sorted(participant)
    completion = sorted(completion)
    
    for _ in range(len(participant)):
        if len(completion) == _:
            return participant[_]
        elif participant[_] != completion[_]:
            return participant[_]
            
