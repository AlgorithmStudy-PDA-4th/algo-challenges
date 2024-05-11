n,c=map(int,input().split())
x=[]
for i in range(n):
    x.append(int(input()))
x.sort()

start=1
end=x[-1]-x[0]
result=0

while start<=end:
    mid=(start+end)//2
    value=x[0]
    count=1
    for i in range(1,n):
        if x[i]>=value+mid:
            value=x[i]
            count+=1
    if count>=c:
        result=mid
        start=mid+1
    else:
        end=mid-1

print(result)