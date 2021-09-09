import sys
import math

n = int(sys.stdin.readline().rstrip())

home = list(map(int, sys.stdin.readline().rstrip().split()))
home.sort()

index = math.ceil(n / 2) - 1

print(home[index])
