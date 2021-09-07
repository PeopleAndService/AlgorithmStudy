"""
그리디
1이 될 때까지
제한 : 1초 / 128MB
2018 E 기업 알고리즘 대회
"""

import sys

N, K = map(int, sys.stdin.readline().split())
count = 0

while N != 1:
    if N % K == 0:
        count += 1
        N = N // K
    else:
        count += (N % K)
        N -= (N % K)

print(count)
