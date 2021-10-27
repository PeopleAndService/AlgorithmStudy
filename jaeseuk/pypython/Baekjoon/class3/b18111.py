from sys import stdin

n, m, b = map(int, stdin.readline().rstrip().split())
land = []

for _ in range(n):
    lan = list(map(int, stdin.readline().rstrip().split()))
    land += lan

land.sort(reverse=True)

time = 1e9
height = 0
for i in range(257):
    block = b
    cur_time = 0
    success = True

    for lan in land:
        if lan > i:
            diff = lan - i
            cur_time += diff * 2
            block += diff
        elif lan < i:
            diff = i - lan

            if diff > block:
                success = False
                break

            cur_time += diff
            block -= diff

    if success and time >= cur_time:
        if time == cur_time:
            height = max(height, i)
        else:
            time = cur_time
            height = i

print(time, height)
