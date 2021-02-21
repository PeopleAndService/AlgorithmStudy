# 못 품
import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
lessons = list(map(int, sys.stdin.readline().rstrip().split()))

start = max(lessons)
end = sum(lessons)
result = end

while start <= end:
    mid = (start + end) // 2
    value = 0
    count = 0

    for i in range(n):
        if value + lessons[i] > mid:
            count += 1
            value = 0
        value += lessons[i]

    if count >= m:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)
