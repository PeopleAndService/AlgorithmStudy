"""
정렬, 그리디, 우선순위 큐
카드 정렬하기 (백준 1715 골드4)
제한 : 2초 / 128MB
제출 : 4340(4128)ms / 31672KB
"""

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
