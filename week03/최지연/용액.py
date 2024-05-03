n=int(input())
liquid=list(map(int,input().split()))

start=0
end=n-1
a=0
b=n-1
min_sum=2_000_000_000
while start<end:
    new=liquid[start]+liquid[end]
    if abs(new)<abs(min_sum):
        min_sum=new
        a=start
        b=end
    if new==0:
        break
    elif new<0:
        start+=1
    else:
        end-=1

print(liquid[a],liquid[b])