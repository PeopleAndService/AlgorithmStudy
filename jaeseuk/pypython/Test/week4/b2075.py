from sys import stdin
import heapq

n = int(stdin.readline().rstrip())
q = []

for _ in range(n):
    if not q:
        for num in list(map(int, stdin.readline().rstrip().split())):
            heapq.heappush(q, num)
    else:
        for num in list(map(int, stdin.readline().rstrip().split())):
            if q[0] < num:
                heapq.heappush(q, num)
                heapq.heappop(q)

print(q[0])
