from sys import stdin

n, m = map(int, stdin.readline().rstrip().split())
trees = list(map(int, stdin.readline().rstrip().split()))
trees.sort()

left = 0
right = trees[-1]

height = 0
while left <= right:
    total = 0
    mid = (left + right) // 2

    for tree in trees:
        if tree > mid:
            total += tree - mid

    if total < m:
        right = mid - 1
    else:
        height = mid
        left = mid + 1

print(height)
