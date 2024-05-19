N, S = map(int, input().split())
num = list(map(int, input().split()))
answer = 0
part = []

def solve(start):
    global answer
    if sum(part) == S and len(part) > 0:
        answer += 1

    for i in range(start, N):
        part.append(num[i])
        solve(i+1)
        part.pop()

solve(0)
print(answer)
