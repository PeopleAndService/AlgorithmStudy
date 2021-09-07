# 더 맵게

import heapq


def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while scoville[0] < K:
        food = heapq.heappop(scoville) + heapq.heappop(scoville) * 2
        if len(scoville) == 0 and food < K:
            return -1
        heapq.heappush(scoville, food)
        answer += 1
    return answer