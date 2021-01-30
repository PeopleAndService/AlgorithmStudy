import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
cards = []

for _ in range(n):
    cards.append(list(map(int, sys.stdin.readline().rstrip().split())))

result = 0
for card in cards:
    row_min = min(card)
    result = max(result, row_min)

print(result)
