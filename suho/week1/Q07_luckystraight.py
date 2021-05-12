"""
구현, 문자열
럭키 스트레이트 (백준 18406 브론즈2)
제한 : 1초 / 256MB
제출 : 72ms / 28776KB
"""

import sys

N = list(map(int, sys.stdin.readline().rstrip()))
mid = len(N) // 2
l_sum = 0
r_sum = 0

# 왼쪽 합
for i in range(mid):
    l_sum += N[i]

# 오른쪽 합
for j in range(mid, len(N)):
    r_sum += N[j]

if l_sum == r_sum:
    print("LUCKY")
else:
    print("READY")
