# 기능 개발

from collections import deque
import math

def solution(progresses, speeds):
    answer = []
    recent, speed_idx, index = 0, 0, -1
    schedule = deque(progresses)
    while schedule:
        work = schedule.popleft()
        r_time = math.ceil((100-work)/speeds[speed_idx])
        if recent >= r_time:
            answer[index] += 1
        else:
            recent = r_time
            answer.append(1)
            index += 1
        speed_idx += 1
    return answer

print(solution([93, 30, 55],[1, 30, 5]))
print(solution([95, 90, 99, 99, 80, 99],[1, 1, 1, 1, 1, 1]))