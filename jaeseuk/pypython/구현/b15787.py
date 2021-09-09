import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
trains = [[0] * 20 for _ in range(n)]
orders = []

for _ in range(m):
    orders.append(list(map(int, sys.stdin.readline().rstrip().split())))

for order in orders:
    if order[0] == 1:
        if trains[order[1] - 1][order[2] - 1] == 0:
            trains[order[1] - 1][order[2] - 1] = 1
    elif order[0] == 2:
        if trains[order[1] - 1][order[2] - 1] == 1:
            trains[order[1] - 1][order[2] - 1] = 0
    elif order[0] == 3:
        if trains[order[1] - 1][19] == 1:
            trains[order[1] - 1][19] = 0
        last_pass = trains[order[1] - 1].pop()
        trains[order[1] - 1].insert(0, last_pass)
    else:
        if trains[order[1] - 1][0] == 1:
            trains[order[1] - 1][0] = 0
        first_pass = trains[order[1] - 1].pop(0)
        trains[order[1] - 1].insert(19, first_pass)

pass_log = []
count = 0
for train in trains:
    if train not in pass_log:
        pass_log.append(train)
        count += 1

print(count)
