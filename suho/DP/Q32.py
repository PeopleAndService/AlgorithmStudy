import sys

n = int(input())
triangle = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
triangle = triangle[::-1]
sum = [[0] * i for i in reversed(range(1, n+1))]
sum[0] = triangle[0]
for i in range(1, n):
    for j in range(0, len(sum[i])):
        sum[i][j] = max(sum[i-1][j], sum[i-1][j+1]) + triangle[i][j]

print(sum[n-1][0])
