from sys import stdin
from collections import Counter

n = int(stdin.readline().rstrip())
data = Counter([int(stdin.readline().rstrip()) for _ in range(n)])
result = sorted(data.most_common(), key=lambda x: (-x[1], x[0]))

print(result[0][0])
