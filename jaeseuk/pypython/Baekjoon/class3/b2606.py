from sys import stdin
from collections import deque

c = int(stdin.readline().rstrip())
e = int(stdin.readline().rstrip())
graph = [[] for _ in range(c + 1)]

for _ in range(e):
    a, b = map(int, stdin.readline().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

visited = {1}
q = deque(graph[1])
answer = 0

while q:
    now = q.popleft()

    if now not in visited:
        visited.add(now)
        answer += 1
        for node in graph[now]:
            q.appendleft(node)

print(answer)
