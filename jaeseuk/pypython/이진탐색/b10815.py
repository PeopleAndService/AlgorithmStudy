from sys import stdin

n = int(stdin.readline().rstrip())
cards = set(map(int, stdin.readline().rstrip().split()))
m = int(stdin.readline().rstrip())
checks = list(map(int, stdin.readline().rstrip().split()))

for check in checks:
    if check in cards:
        print(1, end=' ')
    else:
        print(0, end=' ')
