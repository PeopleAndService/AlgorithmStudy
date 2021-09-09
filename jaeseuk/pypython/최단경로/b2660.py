from sys import stdin

INF = int(1e9)
n = int(stdin.readline().rstrip())
graph = [[INF] * (n + 1) for _ in range(n + 1)]

while True:
    a, b = map(int, stdin.readline().rstrip().split())

    if a == -1 and b == -1:
        break

    graph[a][b] = 1
    graph[b][a] = 1

for i in range(1, n + 1):
    graph[i][i] = 0

for c in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][c] + graph[c][b])

result = []
for i in range(1, n + 1):
    score = graph[i][1]
    for j in range(2, n + 1):
        if score < graph[i][j]:
            score = graph[i][j]
    result.append(score)

score = min(result)
count = result.count(score)
print(score, count)

for i in range(len(result)):
    if result[i] == score:
        print(i + 1, end=' ')
