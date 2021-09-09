import sys

n = int(sys.stdin.readline().rstrip())
x = list(map(int,  sys.stdin.readline().rstrip().split()))
x.sort()

std = x[0]
count = 0
while len(x) != 0:
    if len(x) >= std:
        for _ in range(std):
            x.pop(0)
        count += 1
    else:
        break
    if x:
        std = x[0]

print(count)
