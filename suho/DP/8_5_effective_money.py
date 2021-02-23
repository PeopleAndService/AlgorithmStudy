N, M = map(int, input().split())
money = []
for _ in range(N):
    money.append(int(input()))

result = [10e9]*(M+1)
result[0] = 0
for i in range(N):
    for j in range(money[i], M+1):
        result[j] = min(result[j], result[j-money[i]]+1)

if result[M] == 10e9:
    print(-1)
else:
    print(result[M])
