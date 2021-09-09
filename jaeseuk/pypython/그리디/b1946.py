import sys
import heapq

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    scores = []
    for _ in range(n):
        heapq.heappush(scores, tuple(list(map(int, sys.stdin.readline().rstrip().split()))))
    inter_min = heapq.heappop(scores)[1]
    result = 1

    while len(scores) != 0:
        score = heapq.heappop(scores)
        if score[1] < inter_min:
            result += 1
            inter_min = score[1]

    print(result)
