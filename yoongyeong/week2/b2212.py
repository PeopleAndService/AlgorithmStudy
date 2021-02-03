# 센서

import sys

N = int(input())
K = int(input())
sensor = set(map(int, sys.stdin.readline().rstrip().split()))

sensors = sorted(list(sensor))

distance = []
for i in range(len(sensors)-1):
    distance.append(sensors[i+1]-sensors[i])

distance.sort(reverse=True)

print(sum(distance[K-1:]))

