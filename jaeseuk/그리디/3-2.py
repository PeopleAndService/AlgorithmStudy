import sys

n, m, k = map(int, sys.stdin.readline().rstrip().split())
number = list(map(int, sys.stdin.readline().rstrip().split()))
number.sort(reverse=True)

result = 0
count = 0
for _ in range(m):
    if count == k:
        result += number[1]
        count = 0
    else:
        result += number[0]
        count += 1

print(result)
