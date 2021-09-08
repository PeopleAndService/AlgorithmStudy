"""
DP, 최장 부분 증가 수열
병사 배치하기 (백준 18353 실버2)
제한 : 1초 / 256MB
제출 : 904ms / 29028KB
"""

import sys

n = int(input())
soldier = list(map(int, sys.stdin.readline().rstrip().split()))
result = [1] * n
for i in range(1, n):
    for j in range(0, i):
        if soldier[j] > soldier[i]:
            result[i] = max(result[i], result[j] + 1)
print(n - result[n-1])
