"""
이진 탐색, 파라메트릭 서치
공유기 설치 (백준 2110 실버1)
제한 : 2초 / 128MB
제출 : 4364ms / 32628KB
"""

N, C = map(int, input().split())
home = [int(input()) for _ in range(N)]
home.sort()

# 최소간격 1, 최대 간격 양끝집 차이
start = 1
end = home[N-1] - home[0]
length = 0

while start <= end:
    mid = (start + end) // 2
    installed = home[0]
    cnt = 1
    for i in range(1, N):
        # 설치할라면 인접 공유기니까 간격이 mid 보다 같거나 커야됌
        if home[i] - installed >= mid:
            cnt += 1
            installed = home[i]

    # C개 만큼 설치 못했으면 간격 줄여
    if cnt < C:
        end = mid - 1
    # 최대한 많은 집에서 와이파이 사용이니까 C개 보다 많이 설치하면 간격 늘려봐 = mid 간격으로 적어도 C개 이상 설치 해야됌
    else:
        length = mid
        start = mid + 1

print(length)
