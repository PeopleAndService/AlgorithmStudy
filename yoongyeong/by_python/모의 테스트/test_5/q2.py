def bfs(x, y):
    queue = [[x, y]]
    while queue:
        ax, bx = queue[0][0], queue[0][1]
        del queue[0]
        for index in range(4):
            nq = ax + dx[index]
            nw = bx + dy[index]
            if 0 <= nq < n and 0 <= nw < m and s[nq][nw] == 1:
                s[nq][nw] = 0
                queue.append([nq, nw])

test_case = int(input())
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(test_case):
    m, n, k = map(int, input().split())
    s = [[0] * m for _ in range(n)]
    bachu = []
    cnt = 0
    for j in range(k):
        a, b = map(int, input().split())
        s[b][a] = 1
        bachu.append((b, a))
    for q, w in bachu:
        if s[q][w] == 1: bfs(q, w); s[q][w] = 0; cnt += 1
    print(cnt)
