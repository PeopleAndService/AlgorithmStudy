from sys import stdin

n, m = map(int, stdin.readline().rstrip().split())
prefix = [0] * (n + 1)
numbers = list(map(int, stdin.readline().rstrip().split()))

for i in range(1, len(numbers) + 1):
    prefix[i] = prefix[i - 1] + numbers[i - 1]

for _ in range(m):
    i, j = map(int, stdin.readline().rstrip().split())
    print(prefix[j] - prefix[i - 1])
