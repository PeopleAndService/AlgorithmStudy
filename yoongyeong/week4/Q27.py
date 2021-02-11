# 정렬된 배열에서 특정 수의 개수 구하기
from bisect import bisect_left, bisect_right

n, x = map(int, input().split())
numbers = list(map(int, input().split()))

rIndex = bisect_right(numbers, x)
lIndex = bisect_left(numbers, x)

if rIndex - lIndex == 0:
    print(-1)
else:
    print(rIndex - lIndex)