n = int(input())
paper = [[0 for _ in range(100)] for _ in range(100)]
for i in range(n):
    tmp_x,tmp_y = map(int,input().split())
    for x in range(tmp_x,tmp_x + 10):
        for y in range(tmp_y,tmp_y + 10):
            if x >= 100 or y >= 100:
                break
            paper[x][y] = 1
            
sum = 0
for row in range(100):
    sum += paper[row].count(1)

print(sum)
