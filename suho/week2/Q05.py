N, M = map(int, input().split())
balls = list(map(int, input().split()))
comb = []

for i in range(len(balls)):
    for j in range(i, len(balls)):
        if balls[i] == balls[j]:
            continue
        else:
            comb.append((i, j))

print(len(comb))
