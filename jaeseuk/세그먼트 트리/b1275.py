from sys import stdin
from math import ceil, log2


def init(idx, start, end):
    if start == end:
        tree[idx] = number[start - 1]
    else:
        mid = (start + end) // 2
        tree[idx] = init(idx * 2, start, mid) + init(idx * 2 + 1, mid + 1, end)

    return tree[idx]


def get_sum(idx, start, end, left, right):
    if right < start or end < left:
        return 0
    elif left <= start and end <= right:
        return tree[idx]
    else:
        mid = (start + end) // 2
        return get_sum(idx * 2, start, mid, left, right) + get_sum(idx * 2 + 1, mid + 1, end, left, right)


def update(idx, start, end, node, diff):
    if node < start or node > end:
        return

    tree[idx] += diff

    if start != end:
        mid = (start + end) // 2
        update(idx * 2, start, mid, node, diff)
        update(idx * 2 + 1, mid + 1, end, node, diff)


n, q = map(int, stdin.readline().rstrip().split())
number = list(map(int, stdin.readline().rstrip().split()))
tree_size = 2 ** (ceil(log2(n)) + 1) - 1
tree = [0] * (tree_size + 1)

init(1, 1, n)

for _ in range(q):
    x, y, a, b = map(int, stdin.readline().rstrip().split())

    if x > y:
        print(get_sum(1, 1, n, y, x))
    else:
        print(get_sum(1, 1, n, x, y))

    update(1, 1, n, a, b - number[a - 1])
    number[a - 1] = b
