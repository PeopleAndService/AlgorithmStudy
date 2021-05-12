"""
DP
백준 1965 상자넣기 실버2
제한 : 2초 / 128MB
제출 : 284ms / 28776KB
"""

import sys

n = int(input())
array = list(map(int, sys.stdin.readline().rstrip().split()))
dp = [1]*n

for i in range(1, n):
    for j in range(0, i + 1):
        if array[j] < array[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))
