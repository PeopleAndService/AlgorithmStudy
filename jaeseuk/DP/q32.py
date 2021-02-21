import sys

n = int(sys.stdin.readline().rstrip())

dp = []
for _ in range(n):
    dp.append(list(map(int, sys.stdin.readline().rstrip().split())))

for i in range(1, n):
    for j in range(len(dp[i])):
        if j == 0:
            left_up = 0
        else:
            left_up = dp[i - 1][j - 1]
        if j == len(dp[i]) - 1:
            right_up = 0
        else:
            right_up = dp[i - 1][j]
        dp[i][j] = dp[i][j] + max(left_up, right_up)

result = 0
for i in range(len(dp[n - 1])):
    result = max(result, dp[n - 1][i])

print(result)
