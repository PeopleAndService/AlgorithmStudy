from collections import deque


def checkRight(index, rotation):
    checks = [0] * 4
    checks[index] = rotation
    ldex, rdex = index, index
    while checks[ldex] != 0:
        if ldex == 0: break
        if wheels[ldex][6] != wheels[ldex - 1][2]: checks[ldex - 1] = 1 if checks[ldex] == -1 else -1
        else: break
        ldex -= 1
    while checks[rdex] != 0:
        if rdex == 3: break
        if wheels[rdex][2] != wheels[rdex + 1][6]: checks[rdex + 1] = 1 if checks[rdex] == -1 else -1
        else: break
        rdex += 1
    return checks


wheels = []
for _ in range(4):
    wheels.append(deque(list(input())))
k = int(input())

for _ in range(k):
    number, direction = map(int, input().split())
    checks = checkRight(number-1, direction)
    for i in range(4): wheels[i].rotate(checks[i])

score = 0
for i, wheel in enumerate(wheels):
    if wheel[0] == "1": score += (2 ** i)

print(score)
