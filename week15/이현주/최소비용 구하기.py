import heapq 

n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, cost = map(int, input().split())
    graph[a].append([b, cost])
        
start, end = map(int, input().split())
costs = [1e9 for _ in range(n+1)]
queue = []
costs[start] = 0
heapq.heappush(queue, [0, start])
    
while queue:
    cur_cost, cur_v = heapq.heappop(queue)
    if costs[cur_v] < cur_cost:
        continue
    for next_v, next_cost in graph[cur_v]:
        sum_cost = cur_cost + next_cost
        if sum_cost >= costs[next_v]:
            continue
        
        costs[next_v] = sum_cost
        heapq.heappush(queue, [sum_cost, next_v])
        
print(costs[end])
