import sys

n = int(sys.stdin.readline().rstrip())
k = int(sys.stdin.readline().rstrip())

sensors = list(map(int, sys.stdin.readline().rstrip().split()))
sensors.sort()

diff = []
for i in range(len(sensors)):
    if i != len(sensors) - 1:
        diff.append(sensors[i + 1] - sensors[i])

diff.sort()

result = 0
for j in range(n - k):
    result += diff[j]

print(result)
