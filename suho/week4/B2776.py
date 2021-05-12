"""
이진 탐색, 정렬, 해시맵
백준 2776 암기왕 실버3
제한 : 2초 / 256MB
제출 : 6800ms / 184220KB
"""

import sys


def binary_search(n, a):
    start = 0
    end = len(a) - 1
    while start <= end:
        mid = (start + end) // 2
        if n == a[mid]:
            return True
        if n < a[mid]:
            end = mid - 1
        else:
            start = mid + 1
    return False


T = int(input())
for _ in range(T):
    N = int(input())
    first_note = list(map(int, sys.stdin.readline().rstrip().split()))
    M = int(input())
    second_note = list(map(int, sys.stdin.readline().rstrip().split()))
    first_note.sort()
    for num in second_note:
        if binary_search(num, first_note):
            print(1)
        else:
            print(0)
