import sys
import bisect
#
#
# def find_start(list, key):
#     start = 0
#     end = len(list)
#     while start < end:
#         mid = (start + end) // 2
#         if list[mid] < key:
#             start = mid + 1
#         else:
#             end = mid
#     return start
#
#
# def find_end(list, key):
#     start = 0
#     end = len(list)
#     while start < end:
#         mid = (start + end) // 2
#         if key < list[mid]:
#             end = mid
#         else:
#             start = mid + 1
#     return start


N, x = map(int, input().split())
nums = list(map(int, sys.stdin.readline().rstrip().split()))

if x in nums:
    # start = find_start(nums, x)
    # end = find_end(nums, x)
    start = bisect.bisect_left(nums, x)
    end = bisect.bisect_right(nums, x)
    print(end - start)
else:
    print(-1)
