import sys

n = int(input())
soldier = list(map(int, sys.stdin.readline().rstrip().split()))
result = [1] * n
for i in range(1, n):
    for j in range(0, i):
        if soldier[j] > soldier[i]:
            result[i] = max(result[i], result[j] + 1)
print(n - result[n-1])
