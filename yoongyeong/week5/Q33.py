# 퇴사 (삼성전자 SW 역량테스트, 백준 18353)

n = int(input())
t, p = [], []
d = [0] * (n + 1)

for _ in range(n):
    ti, pi = map(int, input().split())
    t.append(ti)
    p.append(pi)

for i in range(n):
    index = n - 1 - i
    if t[index] + index <= n:
        time = t[index]
        d[index] = max(d[index + time:]) + p[index]

print(max(d))
