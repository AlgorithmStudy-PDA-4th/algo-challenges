def solution(phone_book):
    answer = True
    phone_book.sort()
    data={}
    for i in phone_book:
        data[i]=1
    for i in phone_book:
        for j in range(1,len(i)):
            if data.get(i[:j])==1:
                return False  
    return answer