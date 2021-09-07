"""
구현(완전 탐색)
시각
제한 : 2초 / 128MB
"""

import sys

N = int(sys.stdin.readline())
count = 0

for i in range(N + 1):
    if i % 10 == 3:
        count += 60**2
        continue
    for m in range(60):
        if m // 10 == 3 or m % 10 == 3:
            count += 60
            continue
        for s in range(60):
            if s // 10 == 3 or s % 10 == 3:
                count += 1

print(count)
