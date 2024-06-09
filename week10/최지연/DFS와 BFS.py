from collections import deque

n,m,v=map(int,input().split())
graph=[[] for i in range(n+1)]

for _ in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1,n+1):
    graph[i].sort()

visited=[False]*(n+1)
def dfs(graph,v,visited):
    print(v,end=" ")
    visited[v]=True
    for g in graph[v]:
        if not visited[g]:
            dfs(graph,g,visited)
dfs(graph,v,visited)
print()

visited=[False]*(n+1)
def bfs(graph,v,visited):
    q=deque([v])
    visited[v]=True
    while q:
        v=q.popleft()
        print(v,end=" ")
        for g in graph[v]:
            if not visited[g]:
                q.append(g)
                visited[g]=True
bfs(graph,v,visited)