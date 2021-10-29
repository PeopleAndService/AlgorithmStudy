from collections import deque


def solution(priorities, location):
    answer = 0
    max_pri = sorted(priorities)
    priorities = deque(enumerate(priorities))

    while True:
        idx, pri = priorities.popleft()

        if pri == max_pri[-1]:
            answer += 1
            max_pri.pop()

            if idx == location:
                break
        else:
            priorities.append((idx, pri))

    return answer
