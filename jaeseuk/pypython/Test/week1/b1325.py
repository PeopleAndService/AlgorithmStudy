from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().rstrip().split())
graph = [[] for _ in range(n + 1)]
answer = []

for _ in range(m):
    a, b = map(int, stdin.readline().rstrip().split())
    graph[b].append(a)

for i in range(1, n + 1):
    q = deque(graph[i])
    visited = [False] * (n + 1)
    visited[i] = True

    cnt = 0
    while q:
        now = q.popleft()

        if not visited[now]:
            cnt += 1
            visited[now] = True

            for node in graph[now]:
                q.append(node)

    answer.append((i, cnt))

answer.sort(key=lambda x: -x[1])

for node in answer:
    if node[1] == answer[0][1]:
        print(node[0], end=' ')
