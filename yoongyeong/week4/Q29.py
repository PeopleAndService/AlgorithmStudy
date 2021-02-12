# 공유기 설치 (백준 2110)

N, C = map(int, input().split())
sharer = [int(input()) for i in range(N)]
sharer.sort()

start = 1
end = result = sharer[-1] - sharer[0]

while start <= end:
    mid = (start + end) // 2

    count = 1
    house = sharer[0]  # 공유기를 설치한 집
    for i in range(1, N):
        if mid <= sharer[i] - house:
            count += 1
            house = sharer[i]

    if count < C:
        end = mid - 1
    elif count >= C:
        result = mid
        start = mid + 1

print(result)