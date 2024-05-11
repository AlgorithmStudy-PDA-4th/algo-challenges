n=int(input())
arr=list(map(int,input().split()))
start=0
end=n-1
ans=arr[start]+arr[end]
while start<end:
    tmp=arr[start]+arr[end]
    if abs(ans)>abs(tmp):
        ans=arr[start]+arr[end]
    if tmp==0:
        break
    elif tmp>0:
        end-=1
    elif tmp<0:
        start+=1

print(ans)