import heapq


def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0

    while len(scoville) >= 2 and scoville[0] < K:
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        new = first + second * 2
        heapq.heappush(scoville, new)
        answer += 1

    return answer if scoville[0] >= K else -1
