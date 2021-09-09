import sys

n = int(sys.stdin.readline().rstrip())

numbers = []
for _ in range(n):
    numbers.append(int(sys.stdin.readline().rstrip()))

numbers.sort(reverse=True)
for number in numbers:
    print(number, end=' ')
