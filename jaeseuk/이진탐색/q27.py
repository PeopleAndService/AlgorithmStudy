import sys
import bisect

n, x = map(int, sys.stdin.readline().rstrip().split())
data = list(map(int, sys.stdin.readline().rstrip().split()))

left = bisect.bisect_left(data, x)
right = bisect.bisect_right(data, x)

if left == right:
    print(-1)
else:
    print(right - left)