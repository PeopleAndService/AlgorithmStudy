from sys import stdin

k, n = map(int, stdin.readline().rstrip().split())
lines = sorted([int(stdin.readline().rstrip()) for _ in range(k)])

start = 1
end = lines[-1]

length = 0
while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for line in lines:
        if mid <= line:
            cnt += line // mid

    if cnt < n:
        end = mid - 1
    else:
        length = mid
        start = mid + 1

print(length)
