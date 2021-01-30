import heapq


def solution(food_times, k):
    if sum(food_times) <= k:
        return -1

    times = []
    for i in range(len(food_times)):
        heapq.heappush(times, [food_times[i], i+1])

    time = 0
    min_time = 0
    n = len(food_times)

    while time + ((times[0][0] - min_time) * n) <= k:
        temp = heapq.heappop(times)
        time += (temp[0] - min_time) * n
        min_time = temp[0]
        n -= 1

    times.sort(key=lambda x: x[1])
    return times[(k - time) % n][1]


print(solution([3, 1, 2], 5))
