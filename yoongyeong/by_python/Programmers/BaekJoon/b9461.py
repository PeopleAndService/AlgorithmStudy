dp = [0, 1, 1, 1] + [0] * 100
for i in range(1, 100): dp[i+3] = dp[i]+dp[i+1]
for _ in range(int(input())): print(dp[int(input())])