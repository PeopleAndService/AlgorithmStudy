import sys

N = int(input())
array_liquid = list(map(int, sys.stdin.readline().rstrip().split()))
array_liquid.sort()

start = 0
end = N - 1
cur_gap = abs(array_liquid[start] + array_liquid[end])
cur_start = start
cur_end = end

while start < end:
    sum = array_liquid[start] + array_liquid[end]
    gap = abs(sum)
    if gap < cur_gap:
        cur_start = start
        cur_end = end
        cur_gap = gap
    if cur_gap == 0:
        break
    if sum < 0:
        start += 1
    else:
        end -= 1

print(array_liquid[cur_start], array_liquid[cur_end])
