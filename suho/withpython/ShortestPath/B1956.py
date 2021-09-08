INF = int(1e9)

v, e = map(int, input().split())
graph = [[INF] * (v+1) for _ in range(v+1)]
for _ in range(e):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for p in range(1, v+1):
    for s in range(1, v+1):
        for e in range(1, v+1):
            graph[s][e] = min(graph[s][e], graph[s][p] + graph[p][e])

result = INF
for i in range(1, v+1):
    result = min(result, graph[i][i])

if result == INF:
    print(-1)
else:
    print(result)
