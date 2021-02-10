import sys

N = int(sys.stdin.readline().rstrip())
lines = [tuple(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
lines.sort()

start = lines[0][0]
end = lines[0][1]
length = abs(end - start)

for x, y in lines:
    # 이미 그려진 직선에 포함
    if start <= x and y <= end:
        continue

    # 그려놓고
    length += abs(y - x)
    # 직선끼리 겹치는 부분 제외
    if end > x:
        length -= abs(end - x)

    # 시작, 끝점 바꾸기
    start = x
    end = y

print(length)
