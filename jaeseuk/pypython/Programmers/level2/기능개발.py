from collections import deque
import math


def solution(progresses, speeds):
    progresses = deque(progresses)
    speeds = deque(speeds)
    answer = []

    while progresses:
        progress = progresses.popleft()
        speed = speeds.popleft()
        cnt = 1
        release = math.ceil((100 - progress) / speed)

        for i in range(len(progresses)):
            progresses[i] += speeds[i] * release

        while progresses and progresses[0] >= 100:
            cnt += 1
            progresses.popleft()
            speeds.popleft()

        answer.append(cnt)

    return answer
