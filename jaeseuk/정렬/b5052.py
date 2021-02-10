import sys

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())

    tels = []
    for _ in range(n):
        tels.append(sys.stdin.readline().rstrip())

    tels.sort()
    result = 'YES'
    for i in range(n - 1):
        index = len(tels[i])
        if tels[i] == tels[i + 1][:index]:
            result = 'NO'
            break

    print(result)
