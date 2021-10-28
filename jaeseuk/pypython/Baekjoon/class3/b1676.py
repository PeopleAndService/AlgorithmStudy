from sys import stdin

n = int(stdin.readline().rstrip())
dp = [0] * (n + 1)
dp[0] = 1

if n > 0:
    dp[1] = 1

for i in range(2, n + 1):
    dp[i] = i * dp[i - 1]

answer = 0
for i in str(dp[n])[::-1]:
    if i != '0':
        break
    answer += 1

print(answer)
