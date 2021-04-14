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


n = int(input())
m = int(input())
parent = [0] * (n+1)
edge = []
result = 0

for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().rstrip().split())
    heapq.heappush(edge, (c, a, b))

for i in range(1, n+1):
    parent[i] = i

while edge:
    cur_cost, a, b = heapq.heappop(edge)
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += cur_cost

print(result)
