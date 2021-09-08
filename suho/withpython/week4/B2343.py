"""
이진 탐색
백준 2343 기타 레슨 실버1
제한 : 2초 / 128MB
제출 : 828ms / 40320KB
"""

import sys

N, M = map(int, input().split())
array_lesson = list(map(int, sys.stdin.readline().rstrip().split()))

start = max(array_lesson)
end = sum(array_lesson)
result = 0

while start <= end:
    mid = (start + end) // 2
    count = 1
    sum = array_lesson[0]
    for i in range(1, N):
        if sum + array_lesson[i] <= mid:
            sum += array_lesson[i]
        else:
            count += 1
            sum = array_lesson[i]

    if count > M:
        start = mid + 1
    else:
        result = mid
        end = mid - 1

print(result)
