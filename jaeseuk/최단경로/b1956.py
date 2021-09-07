from sys import stdin

INF = int(1e9)
v, e = map(int, stdin.readline().rstrip().split())
graph = [[INF] * (v + 1) for _ in range(v + 1)]

for _ in range(e):
    a, b, c = map(int, stdin.readline().rstrip().split())
    graph[a][b] = c

for c in range(1, v + 1):
    for a in range(1, v + 1):
        for b in range(1, v + 1):
            graph[a][b] = min(graph[a][b], graph[a][c] + graph[c][b])

result = INF
for i in range(1, v + 1):
    if graph[i][i] != INF:
        result = min(result, graph[i][i])

if result == INF:
    print(-1)
else:
    print(result)
