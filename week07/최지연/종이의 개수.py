n=int(input())
paper=[]
for i in range(n):
    paper.append(list(map(int,input().split())))

def checkPaper(paper,x1,x2,y1,y2,n):
    flag=paper[x1][y1]
    for i in range(x1,x2):
        for j in range(y1,y2):
            if flag!=paper[i][j]:
                cutPaper(paper,x1,x2,y1,y2,n)
                return

    global cnt1,cnt2,cnt3
    if flag==-1: cnt1+=1
    elif flag==0: cnt2+=1
    else: cnt3+=1


def  cutPaper(paper,x1,x2,y1,y2,n):
    for i in range(x1,x2,n//3):
        for j in range(y1,y2,n//3):
            checkPaper(paper,i,i+n//3,j,j+n//3,n//3)

cnt1=0
cnt2=0
cnt3=0
checkPaper(paper,0,n,0,n,n)
print(cnt1)
print(cnt2)
print(cnt3)