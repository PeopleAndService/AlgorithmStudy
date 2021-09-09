from sys import stdin
from math import factorial


def comb(n, k):
    if n < k:
        return 0
    return factorial(n) // (factorial(n - k) * factorial(k))


m = int(stdin.readline().rstrip())
data = list(map(int, stdin.readline().rstrip().split()))
k = int(stdin.readline().rstrip())

result = 0
for d in data:
    result += comb(d, k)

print(result / comb(sum(data), k))
