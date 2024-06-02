import heapq
import sys
input=sys.stdin.readline
n=int(input())
q=[]
for i in range(n):
    x=int(input())
    if x==0:
        if q:
            print(heapq.heappop(q))
        else:
            print(0)
    else:
        heapq.heappush(q,x)