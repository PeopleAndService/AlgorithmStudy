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
parent = [0] * (n+1)
edge = []
result = 0
max_cost = 0

for i in range(1, n+1):
    parent[i] = i

for _ in range(m):
    a, b, cost = map(int, sys.stdin.readline().rstrip().split())
    heapq.heappush(edge, (cost, a, b))

while edge:
    cost, a, b = heapq.heappop(edge)
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += cost
        max_cost = cost

print(result - max_cost)
