import sys
import heapq

n = int(sys.stdin.readline().rstrip())

cards = []
for _ in range(n):
    heapq.heappush(cards, int(sys.stdin.readline().rstrip()))

result = 0
while len(cards) > 1:
    new_card = heapq.heappop(cards) + heapq.heappop(cards)
    result += new_card
    heapq.heappush(cards, new_card)

print(result)
