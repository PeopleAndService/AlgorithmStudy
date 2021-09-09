import math
from sys import stdin

primes = [True] * 1000001

for i in range(2, int(math.sqrt(1000000)) + 1):
    if primes[i]:
        j = 2

        while i * j <= 1000000:
            primes[i * j] = False
            j += 1

while True:
    n = int(stdin.readline().rstrip())

    if n == 0:
        break

    for i in range(3, n, 2):
        if primes[i] and primes[n - i]:
            print(f"{n} = {i} + {n - i}")
            break
