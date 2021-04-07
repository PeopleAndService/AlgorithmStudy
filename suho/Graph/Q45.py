from collections import deque
import sys

t = int(input())

for _ in range(t):
    n = int(input())
    in_degree = [0] * (n+1)
    graph = [[0] * (n+1) for _ in range(n+1)]

    last_year = list(map(int, sys.stdin.readline().rstrip().split()))

    for i in range(n):
        for j in range(i+1, n):
            graph[last_year[i]][last_year[j]] = 1
            in_degree[last_year[j]] += 1

    m = int(input())
    for _ in range(m):
        a, b = map(int, input().split())
        if graph[a][b] == 1:
            graph[a][b] = 0
            graph[b][a] = 1
            in_degree[a] += 1
            in_degree[b] -= 1
        else:
            graph[a][b] = 1
            graph[b][a] = 0
            in_degree[a] -= 1
            in_degree[b] += 1

    q = deque()
    cur_year = []

    impossible = False
    many_cases = False

    for i in range(1, n+1):
        if in_degree[i] == 0:
            q.append(i)

    for i in range(n):
        if len(q) == 0:
            impossible = True
            break
        if len(q) >= 2:
            many_cases = True
            break

        team = q.popleft()
        cur_year.append(team)

        for i in range(1, n+1):
            graph[team][i] = 0
            in_degree[i] -= 1
            if in_degree[i] == 0:
                q.append(i)

    if impossible:
        print("IMPOSSIBLE")
    elif many_cases:
        print("?")
    else:
        for i in range(n):
            print(cur_year[i], end=' ')
        print()
