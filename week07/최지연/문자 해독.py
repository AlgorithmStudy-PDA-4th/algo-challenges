g,s=map(int,input().split())
w=input()
str=input()

wl=[0]*58
strl=[0]*58

for x in w:
    wl[ord(x)-65]+=1

answer=0
start, length=0,0
for i in range(s):
    strl[ord(str[i])-65]+=1
    length+=1

    if length==g:
        if wl==strl:
            answer+=1
        strl[ord(str[start])-65]-=1
        start+=1
        length-=1

print(answer)