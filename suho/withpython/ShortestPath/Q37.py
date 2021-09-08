INF = int(1e9)

n = int(input())
m = int(input())
graph = [[INF] * (n+1) for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)

for p in range(1, n+1):
    for s in range(1, n+1):
        for e in range(1, n+1):
            if s == e:
                continue
            graph[s][e] = min(graph[s][e], graph[s][p] + graph[p][e])

for i in range(1, n+1):
    for j in range(1, n+1):
        if graph[i][j] >= INF:
            print(0, end=' ')
        else:
            print(graph[i][j], end=' ')
    print()
