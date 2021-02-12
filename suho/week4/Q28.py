import sys

N = int(input())
nums = list(map(int, sys.stdin.readline().rstrip().split()))

start = 0
end = len(nums)
flag = False
while start <= end:
    mid = (start + end) // 2
    if nums[mid] == mid:
        flag = True
        print(mid)
        break
    if nums[mid] < mid:
        start = mid + 1
    else:
        end = mid - 1

if not flag:
    print(-1)
