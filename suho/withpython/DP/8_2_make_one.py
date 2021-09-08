"""
DP
1로 만들기
제한 : 1초 / 128MB
"""

x = int(input())

d = [0] * (x + 1)

d[2] = 1
d[3] = 1
d[5] = 1

for i in range(4, x + 1):
    d[i] = d[i - 1]

    if i % 5 == 0:
        d[i] = min(d[i], d[i // 5])
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3])
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2])

    d[i] += 1

print(d[x])
