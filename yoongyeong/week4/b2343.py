# 기타 레슨 - 못품

import sys

N, M = map(int, input().split())
blueray = list(map(int, sys.stdin.readline().rstrip().split()))

start, end = max(blueray), sum(blueray)

while start <= end:
    mid = (start + end) // 2
    cnt, play_time = 0, 0

    for music in blueray:
        if play_time + music > mid:
            cnt += 1
            play_time = 0
        play_time += music

    if play_time > 0: cnt += 1

    if cnt <= M:
        end = mid - 1
    else:
        start = mid + 1

print(start)