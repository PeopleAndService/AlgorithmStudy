import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().rstrip().split())
city = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]

home = []
store = []

for i in range(N):
    for j in range(N):
        if city[i][j] == 1:
            home.append((i+1, j+1))
        if city[i][j] == 2:
            store.append((i+1, j+1))

comb = list(combinations(store, M))

result = 100000000

for case in comb:
    sum = 0
    for h in home:
        home_dist = 100000000
        for s in case:
            home_dist = min(home_dist, abs(s[0]-h[0]) + abs(s[1]-h[1]))
        sum += home_dist
    result = min(result, sum)

print(result)
