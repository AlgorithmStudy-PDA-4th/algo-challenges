import sys
from copy import deepcopy  
  
T = int(input())  
for tc in range(T):  
    N, rotate = map(int, input().split())  
    arr = [list(map(int, input().split())) for _ in range(N)]  
    result = [[0]*N for _ in range(N)]  
  
    if rotate < 0:  
        rotate = 360 + rotate  
    if rotate == 360 or rotate == 0:  
        for l in arr:  
            print(*l)  
    else:  
        for _ in range(rotate//45):  
            for i in range(N):  
                for j in range(N):   
                    if i==j:  
                        result[i][j] = arr[N//2][j]   
                    elif i == N//2:  
                        result[i][j] = arr[N-j-1][j]                   
                    elif i+j == N-1:  
                        result[i][j] = arr[i][N//2]  
                    elif j == N//2:  
                        result[i][j] = arr[i][i]   
                    else:  
                        result[i][j] = arr[i][j]  
            arr = deepcopy(result)  
  
        for k in result:  
            print(*k)
