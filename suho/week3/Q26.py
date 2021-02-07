import heapq
N = int(input())
card = []
for _ in range(N):
    heapq.heappush(card, int(input()))
count = 0
while card:
    if len(card) == 1:
        break
    A = heapq.heappop(card)
    B = heapq.heappop(card)
    heapq.heappush(card, A+B)
    count += A + B

print(count)
