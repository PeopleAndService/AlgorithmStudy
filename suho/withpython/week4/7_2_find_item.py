"""
이진 탐색
부품 찾기
제한 : 1초 / 128MB
"""

import sys

N = int(input())
items = list(map(int, sys.stdin.readline().rstrip().split()))
M = int(input())
find = list(map(int, sys.stdin.readline().rstrip().split()))
items.sort()
for piece in find:
    start, end = 0, len(items)
    flag = False
    while start <= end:
        mid = (start + end) // 2
        if items[mid] == piece:
            flag = True
            print('yes', end=' ')
            break
        if items[mid] < piece:
            start = mid + 1
        else:
            end = mid - 1
    if not flag:
        print('no', end=' ')
