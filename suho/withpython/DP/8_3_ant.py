"""
DP
개미 전사
제한 : 1초 / 128MB
"""

import sys

N = int(input())
K = list(map(int, sys.stdin.readline().rstrip().split()))
result = [0] * N
result[0] = K[0]
result[1] = max(K[0], K[1])

for i in range(2, N):
    result[i] = max(result[i-1], result[i-2] + K[i])

print(result[N-1])
