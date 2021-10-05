from sys import stdin
from collections import deque

n, m = map(int, stdin.readline().rstrip().split())
record = set()
trains = [deque(['0'] * 20) for _ in range(n + 1)]
orders = [list(map(int, stdin.readline().rstrip().split())) for _ in range(m)]

for order in orders:
    if order[0] == 1 and trains[order[1]][order[2]] == '0':
        trains[order[1]][order[2]] = '1'
    elif order[0] == 2 and trains[order[1]][order[2]] == '1':
        trains[order[1]][order[2]] = '0'
    elif order[0] == 3:
        trains[order[1]].pop()
        trains[order[1]].appendleft('0')
    elif order[0] == 4:
        trains[order[1]].popleft()
        trains[order[1]].append('0')

answer = 0
for train in trains:
    state = ''.join(train)
    if state not in record:
        answer += 1
        record.add(state)

print(answer)
