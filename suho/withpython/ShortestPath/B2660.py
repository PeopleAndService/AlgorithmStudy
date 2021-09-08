INF = int(1e9)

n = int(input())
graph = [[INF] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    graph[i][i] = 0

while True:
    a, b = map(int, input().split())
    if a and b == -1:
        break
    graph[a][b] = 1
    graph[b][a] = 1

for p in range(1, n+1):
    for s in range(1, n+1):
        for e in range(1, n+1):
            graph[s][e] = min(graph[s][e], graph[s][p] + graph[p][e])

member = []
for i in range(1, n+1):
    member.append(max(graph[i][1:]))

min_score = min(member)
count = member.count(min_score)
print(min_score, count)

for i in range(n):
    if member[i] == min_score:
        print(i+1, end=' ')
