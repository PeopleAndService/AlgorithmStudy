from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 9)


def dfs(idx):
    for node in tree[idx]:
        if parents[node] == 0:
            parents[node] = idx
            dfs(node)


n = int(stdin.readline().rstrip())
tree = [[] for _ in range(n + 1)]
parents = [0] * (n + 1)

for _ in range(n - 1):
    a, b = map(int, stdin.readline().rstrip().split())
    tree[a].append(b)
    tree[b].append(a)

dfs(1)

for i in range(2, n + 1):
    print(parents[i])
