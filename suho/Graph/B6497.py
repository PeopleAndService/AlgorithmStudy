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


while True:
    n, m = map(int, input().split())

    if n == 0 and m == 0:
        sys.exit()

    parent = [0] * n
    edge = []
    total_cost = 0
    min_cost = 0

    for i in range(n):
        parent[i] = i

    for _ in range(m):
        x, y, z = map(int, sys.stdin.readline().rstrip().split())
        heapq.heappush(edge, (z, x, y))
        total_cost += z

    while edge:
        cur_cost, a, b = heapq.heappop(edge)
        if find(parent, a) != find(parent, b):
            union(parent, a, b)
            min_cost += cur_cost

    print(total_cost - min_cost)
