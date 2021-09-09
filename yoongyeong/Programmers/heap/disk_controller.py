# 디스크 컨트롤러

import heapq
import math

def solution(jobs):
    answer, recent_time = 0, 0
    waits = []
    disks = []
    length = len(jobs)
    jobs.sort(reverse=True)
    for i, job in enumerate(jobs):
        waits.append((job[0], i, job[1]))
    while True:
        while len(waits) != 0 and waits[-1][0] <= recent_time:
            job = waits.pop()
            heapq.heappush(disks, (job[2], job[0]))
        if len(waits) != 0 and len(disks) == 0:
            job = waits.pop()
            recent_time += job[0] - recent_time + job[2]
            answer += (recent_time - job[0])
        else:
            if len(disks) == 0: break
            disk = heapq.heappop(disks)
            recent_time += disk[0]
            answer += (recent_time - disk[1])
    return math.floor(answer / length)

print(solution([[0, 10], [4, 10], [15, 2], [5, 11]]))