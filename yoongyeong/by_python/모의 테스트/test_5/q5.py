n = int(input())
port = list(map(int, input().split()))

d = [1] * n

for i in range(1, n):
    for j in range(0, i):
        if port[j] < port[i]: d[i] = max(d[i], d[j] + 1)

print(max(d))