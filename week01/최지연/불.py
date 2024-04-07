from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs():
    cnt = 0
    while q:
        cnt += 1
        while fire and fire[0][2] < cnt:
            x, y, time = fire.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < h and 0 <= ny < w:
                    if board[nx][ny] == "." or board[nx][ny] == "@":
                        board[nx][ny] = "*"
                        fire.append((nx, ny, time + 1))

        while q and q[0][2] < cnt:
            x, y, time = q.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < h and 0 <= ny < w:
                    if board[nx][ny] == "." and not visited[nx][ny]:
                        visited[nx][ny] = True
                        q.append((nx, ny, time + 1))
                else:
                    return cnt
    return "IMPOSSIBLE"

t = int(input())
for _ in range(t):
    w, h = map(int, input().split())

    q = deque()  # 상근이 위치
    fire = deque()  # 불 위치

    board = []
    visited = [[False] * w for _ in range(h)]
    for i in range(h):
        board.append(list(input().strip()))
        for j in range(w):
            if board[i][j] == "@":
                visited[i][j] = True
                q.append((i, j, 0))
            elif board[i][j] == "*":
                fire.append((i, j, 0))

    print(bfs())