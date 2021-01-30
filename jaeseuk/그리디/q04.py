import sys
from itertools import combinations

n = int(sys.stdin.readline().rstrip())
coins = list(map(int, sys.stdin.readline().rstrip().split()))
coins.sort()
result = []

if coins[0] != 1:
    print(1)
else:
    for i in range(1, n + 1):
        for c in combinations(coins, i):
            result.append(sum(c))
result.sort()
for i in range(len(result)):
    if result[i + 1] - result[i] > 1:
        print(result[i] + 1)
        break
