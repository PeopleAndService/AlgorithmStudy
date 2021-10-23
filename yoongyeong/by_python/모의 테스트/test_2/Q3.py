# 3020번 개똥벌레
from bisect import bisect_left

n, h = map(int, input().split())
up, down = [], []

for i in range(n):
    if i % 2 == 0: down.append(int(input()))
    else: up.append(int(input()))

up.sort()
down.sort()

mini, cnt = 1e9, 1
for i in range(1, h+1):
    top, bottom = bisect_left(up, (h+1)-i), bisect_left(down, i)
    obstacle = n - (top + bottom)
    if obstacle < mini: mini, cnt = obstacle, 1
    elif obstacle == mini: cnt += 1

print(mini, cnt)