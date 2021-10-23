import sys

n, m = map(int, input().split())
pokectmons = []
for _ in range(n): pokectmons.append(sys.stdin.readline().rstrip())

for _ in range(m):
    query = sys.stdin.readline().rstrip()
    if query.isdigit(): print(pokectmons[int(query)-1])
    else: print(pokectmons.index(query)+1)