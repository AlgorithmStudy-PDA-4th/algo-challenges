import heapq
n=int(input())
q=[]
for i in range(n):
    q.append(list(map(int,input().split())))

q.sort()

result=[]
heapq.heappush(result,q[0][1])

for i in range(1,n):
    if q[i][0]<result[0]:
        heapq.heappush(result,q[i][1])
    else:
        heapq.heappop(result)
        heapq.heappush(result,q[i][1])

print(len(result))