# 답 봄
import sys

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    n, m = map(int, sys.stdin.readline().rstrip().split())
    data = list(map(int, sys.stdin.readline().rstrip().split()))

    gold = []
    for i in range(n):
        gold.append(data[i*m:(i+1)*m])

    for j in range(1, m):
        for i in range(n):
            if i == 0:
                up = 0
            else:
                up = gold[i - 1][j - 1]
            if i == n - 1:
                down = 0
            else:
                down = gold[i + 1][j - 1]
            left = gold[i][j - 1]
            gold[i][j] = gold[i][j] + max(up, down, left)

    result = 0
    for i in range(n):
        result = max(result, gold[i][m - 1])

    print(result)
