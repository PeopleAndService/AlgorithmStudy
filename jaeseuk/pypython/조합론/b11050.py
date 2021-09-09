from sys import stdin
from math import factorial

n, k = map(int, stdin.readline().rstrip().split())
print(factorial(n) // (factorial(n - k) * factorial(k)))
