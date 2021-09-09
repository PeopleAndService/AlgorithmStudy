# 포도주 시식

n = int(input())
grape = []

for _ in range(n):
    grape.append(int(input()))

if n == 1:
    print(grape[0])
else:
    result = [0, grape[0], grape[0] + grape[1]]
    for i in range(3, n + 1):
        # 1. 이번에 먹고 이전은 안먹었을 때
        # 2. 이번에 먹고 이전것도 먹었을 때
        # 3. 이번에 안먹을때
        case1 = grape[i - 1] + result[i - 2]
        case2 = grape[i - 1] + grape[i - 2] + result[i - 3]
        result.append(max(case1, case2, result[i - 1]))

    print(max(result))