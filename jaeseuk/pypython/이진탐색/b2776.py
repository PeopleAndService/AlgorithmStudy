import sys
from bisect import bisect_left, bisect_right

t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    note1 = list(map(int, sys.stdin.readline().rstrip().split()))
    note1.sort()

    m = int(sys.stdin.readline().rstrip())
    note2 = list(map(int, sys.stdin.readline().rstrip().split()))

    for num in note2:
        if bisect_right(note1, num) == bisect_left(note1, num):
            print(0)
        else:
            print(1)
