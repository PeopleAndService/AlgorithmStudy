n = int(input())
dp = [0, 1] + [0] * (n - 1)

for i in range(2, n + 1): dp[i] = 1 if i == int(i**0.5) ** 2 else i

for i in range(2, n + 1):
    for j in range(1, int(i**0.5) + 1): dp[i] = min(dp[i], dp[j * j] + dp[i - j * j])

print(dp[n])