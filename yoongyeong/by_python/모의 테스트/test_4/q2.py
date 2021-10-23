import sys

n, k = map(int, input().split())
characters = sorted([int(sys.stdin.readline()) for _ in range(n)])
start, end = min(characters), max(characters) + k

result = 0
while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for character in characters:
        if character >= mid: break
        cnt += mid - character

    if cnt <= k: start = mid + 1
    else: end = mid -1

print(end)