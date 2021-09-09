# 카드 정렬하기 (백준 1715)

N = int(input())
card = [int(input()) for _ in range(N)]

result = 0

while len(card) != 1:
    results = []
    card.sort()
    for i in range(0, len(card), 2):
        if i+1 == len(card):
            results.append(card[i])
            break
        if len(results) != 0:
            if max(results) < card[i] + card[i+1]:
                results += card[i:]
                break
        result += card[i] + card[i+1]
        results.append(card[i] + card[i+1])
    card = results

print(result)

"""
--책풀이-- 힙 쓰려다가 잘 모르겠어서 안씀 ㅎㅎ
import heapq

n = int(input())

# 힙(Heap)에 초기 카드 묶음을 모두 삽입
heap = []
for i in range(n):
    data = int(input())
    heapq.heappush(heap, data)

result = 0

# 힙(Heap)에 원소가 1개 남을 때까지
while len(heap) != 1:
    # 가장 작은 2개의 카드 묶음 꺼내기
    one = heapq.heappop(heap)
    two = heapq.heappop(heap)
    # 카드 묶음을 합쳐서 다시 삽입
    sum_value = one + two
    result += sum_value
    heapq.heappush(heap, sum_value)

print(result)
"""