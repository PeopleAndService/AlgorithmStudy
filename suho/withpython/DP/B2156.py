"""
DP
백준 2156 포도주 시식 실버1
제한 : 2초 / 128MB
제출 : 456ms / 29284KB
"""

n = int(input())
grape = [0]
for _ in range(n):
    grape.append(int(input()))

dp = [0]*(n+1)
for i in range(1, n+1):
    if i == 1:
        dp[i] = grape[i]
    elif i == 2:
        dp[i] = grape[i] + grape[i-1]
    else:
        dp[i] = max(dp[i - 1], dp[i - 3] + grape[i - 1] + grape[i], dp[i - 2] + grape[i])

print(dp[-1])
