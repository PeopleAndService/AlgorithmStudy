# 병사 배치하기 (백준 18353)

import sys
n = int(input())
soldiers = list(map(int, sys.stdin.readline().rstrip().split()))
soldiers.reverse()

d = [1] * n

for i in range(1, n):
    for j in range(0, i):
        if soldiers[j] < soldiers[i]:
            d[i] = max(d[i], d[j] + 1)

print(n - max(d))