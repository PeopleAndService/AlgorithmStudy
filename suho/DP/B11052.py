"""
DP
백준 11052 카드 구매하기 실버1
제한 : 1초 / 256MB
제출 : 256ms / 28776KB
"""

import sys

n = int(input())
array = [0]
array.extend(list(map(int, sys.stdin.readline().rstrip().split())))
dp = [0] * (n+1)
dp[1] = array[1]
for i in range(2, n+1):
    dp[i] = array[i]
    for j in range(1, i):
        dp[i] = max(dp[i], dp[i-j] + array[j])

print(dp[n])
