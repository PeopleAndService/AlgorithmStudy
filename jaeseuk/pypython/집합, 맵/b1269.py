from sys import stdin

a_len, b_len = map(int, stdin.readline().rstrip().split())
a = set(map(int, stdin.readline().rstrip().split()))
b = set(map(int, stdin.readline().rstrip().split()))

print(len(a - b) + len(b - a))
