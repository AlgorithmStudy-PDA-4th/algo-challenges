from collections import deque

tc = int(input())

for i in range(tc):
    n, m = map(int, input().split())
    queue = deque(list(map(int, input().split())))
    count = 0
    while queue:
        best = max(queue)
        front = queue.popleft()
        m -= 1

        if best == front:
            count += 1
            if m < 0:
                print(count)
                break

        else:
            queue.append(front)
            if m < 0 :
                m = len(queue) - 1
