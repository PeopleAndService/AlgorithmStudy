N = int(input())
K = int(input())
sensor = list(map(int, input().split()))
sensor.sort()

distance = []
for i in range(1, N):
    distance.append(sensor[i] - sensor[i - 1])

distance.sort(reverse=True)

if K >= N:
    print(0)
else:
    for _ in range(K-1):
        distance.pop(0)
    print(sum(distance))
