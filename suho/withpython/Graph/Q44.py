import sys

sys.setrecursionlimit(10000)


def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n = int(input())
parent = [0] * (n+1)
edge = []
cost = 0

for i in range(n):
    parent[i] = i

x = []
y = []
z = []

for i in range(1, n+1):
    input_planet = list(map(int, input().split()))
    x.append((input_planet[0], i))
    y.append((input_planet[1], i))
    z.append((input_planet[2], i))

x.sort()
y.sort()
z.sort()

for i in range(n-1):
    edge.append((x[i+1][0] - x[i][0], x[i][1], x[i+1][1]))
    edge.append((y[i+1][0] - y[i][0], y[i][1], y[i+1][1]))
    edge.append((z[i+1][0] - z[i][0], z[i][1], z[i+1][1]))

edge.sort()

for e in edge:
    cur_cost, a, b = e
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        cost += cur_cost

print(cost)
