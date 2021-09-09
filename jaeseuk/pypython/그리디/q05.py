import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().rstrip().split())
data = list(map(int, sys.stdin.readline().rstrip().split()))

result = []
for c in combinations(data, 2):
    if c[0] != c[1]:
        result.append(c)

print(len(result))
