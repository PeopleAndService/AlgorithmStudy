"""
DP
정수 삼각형 (백준 1932 실버1)
제한 : 2초 / 128MB
제출 : 164ms / 38300KB
IOI 1994년 기출
"""

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
