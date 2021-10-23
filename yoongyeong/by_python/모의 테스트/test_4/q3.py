import sys

k, n = map(int, input().split())
lan = [int(sys.stdin.readline()) for _ in range(k)]
start, end = 1, max(lan)

while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for l in lan: cnt += l // mid

    if cnt >= n: start = mid + 1
    else: end = mid -1

print(end)