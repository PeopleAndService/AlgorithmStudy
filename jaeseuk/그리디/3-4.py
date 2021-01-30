import sys

n, k = map(int, sys.stdin.readline().rstrip().split())

count = 0
while n != 1:
    if n % k == 0:
        n //= k
    else:
        n -= 1
    count += 1

print(count)
