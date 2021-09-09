# 효율적인 화폐 구성

N, M = map(int, input().split())
moneys = [int(input()) for _ in range(N)]
moneys.sort()

d = [0] * 10001

for i in range(1, M + 1):
    nMoney = 1e9
    for money in moneys:
        if i < money:
            break
        if i == money:
            nMoney = 1
        elif i % money == 0:
            nMoney = min(d[i - money] + 1, nMoney)
    if not nMoney == 1e9:
        d[i] = nMoney

if d[M] == 0:
    print(-1)
else:
    print(d[M])
print(d[:M+1])