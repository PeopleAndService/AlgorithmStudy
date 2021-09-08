INF = int(1e9)

n, m = map(int, input().split())
graph = [[INF] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1

for p in range(1, n+1):
    for s in range(1, n+1):
        for e in range(1, n+1):
            if s == e:
                continue
            graph[s][e] = min(graph[s][e], graph[s][p] + graph[p][e])

count = 0

for i in range(1, n+1):
    temp = 0
    for j in range(1, n+1):
        if graph[i][j] != INF or graph[j][i] != INF:
            temp += 1
    if temp == n:
        count += 1

print(count)
