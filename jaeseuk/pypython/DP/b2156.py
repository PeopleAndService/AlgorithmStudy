from sys import stdin

n = int(stdin.readline().rstrip())

data = []
for _ in range(n):
    data.append(int(stdin.readline().rstrip()))

dp = [0] * (n + 1)
dp[1] = data[0]
for i in range(2, n + 1):
    if i - 3 >= 1:
        temp = dp[i - 3]
    else:
        temp = 0
    dp[i] = max(dp[i - 1], data[i - 1] + data[i - 2] + temp, data[i - 1] + dp[i - 2])

print(dp[n])
