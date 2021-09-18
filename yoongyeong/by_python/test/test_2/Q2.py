# 2725 보이는 점의 개수
import math

dp = [0 for _ in range(1001)]
dp[1] = 3
for i in range(2, 1001):
    cnt = 0
    for j in range(1, i+1):
        if i == j: continue
        if math.gcd(i, j) == 1: cnt += 2
    dp[i] = dp[i-1] + cnt

test_case = int(input())
for _ in range(test_case):
    n = int(input())
    print(dp[n])
