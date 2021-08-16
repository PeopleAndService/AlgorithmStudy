from sys import stdin

dp = [0] * 31
dp[1] = 1

for i in range(2, 31):
    dp[i] = dp[i - 1] * i

for _ in range(int(stdin.readline().rstrip())):
    n, m = map(int, stdin.readline().rstrip().split())

    if n == m:
        print(1)
    else:
        print(dp[m] // (dp[m - n] * dp[n]))
