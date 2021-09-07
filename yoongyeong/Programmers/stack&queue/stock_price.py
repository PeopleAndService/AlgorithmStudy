import heapq


def solution(prices):
    answer = [0] * len(prices)
    queue = []
    for i, price in enumerate(prices):
        while len(queue) != 0:
            if - queue[0][0] > price:
                _, time = heapq.heappop(queue)
                answer[time] = i - time
            else: break
        heapq.heappush(queue, (-price, i))
    for _ in range(len(queue)):
        _, time = heapq.heappop(queue)
        answer[time] = len(prices) - 1 - time
    return answer


print(solution([1, 2, 3, 2, 3]))
