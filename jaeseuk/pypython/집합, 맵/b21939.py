from sys import stdin
import heapq

easy = []
difficult = []
solved = set()

for _ in range(int(stdin.readline().rstrip())):
    p, l = map(int, stdin.readline().rstrip().split())
    heapq.heappush(easy, (l, p))
    heapq.heappush(difficult, (-l, -p))

for _ in range(int(stdin.readline().rstrip())):
    command = list(stdin.readline().rstrip().split())

    if command[0] == 'add':
        heapq.heappush(easy, (int(command[2]), int(command[1])))
        heapq.heappush(difficult, (-int(command[2]), -int(command[1])))
    elif command[0] == 'recommend':
        if int(command[1]) == 1:
            while difficult:
                if -difficult[0][1] in solved:
                    heapq.heappop(difficult)
                else:
                    print(-difficult[0][1])
                    break
        else:
            while easy:
                if easy[0][1] in solved:
                    heapq.heappop(easy)
                else:
                    print(easy[0][1])
                    break
    else:
        solved.add(int(command[1]))
