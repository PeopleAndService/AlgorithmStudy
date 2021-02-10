# 선 긋기

N = int(input())

points = []
for _ in range(N):
    X, Y = map(int, input().split())
    check = False
    indexJ = 0
    for j, point in enumerate(points):
        start, end = point[0], point[1]
        if check:
            nStart, nEnd = points[indexJ]
            if start <= X <= end:
                points.pop(j)
                points[indexJ] = [start, nEnd]
            elif start <= Y <= end:
                points.pop(j)
                points[indexJ] = [nStart, end]
            continue
        if start <= X <= end:
            check = True
            if Y > end:
                points[j] = [start, Y]
                indexJ = j
        elif start <= Y <= end:
            check = True
            points[j] = [X, end]
            indexJ = j
    if not check:
        points.append([X, Y])

result = 0
for start, end in points:
    result += abs(end - start)
print(result)