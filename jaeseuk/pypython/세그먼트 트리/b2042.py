from sys import stdin
from math import log2, ceil


def init(idx, start, end):
    if start == end:
        tree[idx] = number[start - 1]
    else:
        mid = (start + end) // 2
        tree[idx] = init(idx * 2, start, mid) + init(idx * 2 + 1, mid + 1, end)

    return tree[idx]


def update(now, start, end, idx, diff):
    if idx < start or end < idx:
        return

    tree[now] += diff

    if start != end:
        mid = (start + end) // 2
        update(now * 2, start, mid, idx, diff)
        update(now * 2 + 1, mid + 1, end, idx, diff)


def get_sum(idx, start, end, left, right):
    if right < start or end < left:
        return 0
    elif left <= start and end <= right:
        return tree[idx]
    else:
        mid = (start + end) // 2
        return get_sum(idx * 2, start, mid, left, right) + get_sum(idx * 2 + 1, mid + 1, end, left, right)


n, m, k = map(int, stdin.readline().rstrip().split())
number = [int(stdin.readline().rstrip()) for _ in range(n)]
tree_size = 2 ** (ceil(log2(n)) + 1) - 1
tree = [0] * (tree_size + 1)

init(1, 1, n)

for _ in range(m + k):
    a, b, c = map(int, stdin.readline().rstrip().split())

    if a == 1:
        update(1, 1, n, b, c - number[b - 1])
        number[b - 1] = c
    else:
        print(get_sum(1, 1, n, b, c))
