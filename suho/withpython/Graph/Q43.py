import heapq
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


n, m = map(int, input().split())
parent = [-1] * n
edge = []
total_cost = 0
cost = 0

for i in range(n):
    parent[i] = i

for _ in range(m):
    x, y, z = map(int, input().split())
    total_cost += z
    heapq.heappush(edge, (z, x, y))

while edge:
    z, x, y = heapq.heappop(edge)
    if find(parent, x) != find(parent, y):
        union(parent, x, y)
        cost += z

print(total_cost - cost)
