n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)
    
answer = 0
visited = [False] * (n+1)
for i in range(1, n+1):
    if not visited[i]:
        dfs(graph, i, visited)
        answer += 1
print(answer)