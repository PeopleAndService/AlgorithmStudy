import heapq

def solution(a, b, g, s, w, t):
    start_queue, end_queue = [], []
    answer, recent_time = 0, 0
    for i in range(len(t)):
        heapq.heappush(end_queue, [t[i] * 2, -w[i], -g[i], -s[i], i])
    while a + b != 0:
        # 도착
        truck = heapq.heappop(end_queue)
        new_time = recent_time + truck[0]
        while new_time != end_queue[0][0] + recent_time:
            pass
        # 출발
        while start_queue:
            truck = heapq.heappop(start_queue)

    return answer