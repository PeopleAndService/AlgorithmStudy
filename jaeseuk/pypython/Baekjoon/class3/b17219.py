from sys import stdin

n, m = map(int, stdin.readline().rstrip().split())
passwords = {}

for _ in range(n):
    key, value = stdin.readline().rstrip().split()
    passwords[key] = value

for _ in range(m):
    print(passwords[stdin.readline().rstrip()])
