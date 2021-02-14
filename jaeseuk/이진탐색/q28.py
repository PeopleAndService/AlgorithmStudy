import sys

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))

start = 0
end = n - 1
result = -1
while start <= end:
    mid = (start + end) // 2

    if mid == data[mid]:
        result = mid
        break
    elif mid > data[mid]:
        start = mid + 1
    else:
        end = mid - 1

print(result)
