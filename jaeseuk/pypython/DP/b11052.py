# 질문 봄
from sys import stdin

n = int(stdin.readline().rstrip())
data = list(map(int, stdin.readline().rstrip().split()))

dp = [0] * (n + 1)
for i in range(1, n + 1):
    for j in range(1, i + 1):
        temp = dp[i - j] + data[j - 1]
        dp[i] = max(dp[i], temp)

print(dp[n])
