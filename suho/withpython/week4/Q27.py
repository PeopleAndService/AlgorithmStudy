"""
이진 탐색
정렬된 배열에서 특정 수의 개수 구하기
제한 : 1초 / 128MB
Zoho 인터뷰
"""

import sys
import bisect

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
