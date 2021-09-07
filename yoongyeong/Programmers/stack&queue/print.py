# 프린트

from collections import deque


def solution(priorities, location):
    answer, index = 0, 0
    queue = deque([])
    for i in range(len(priorities)):
        queue.append((i, priorities[i]))
    priorities.sort(reverse=True)
    while queue:
        memo = queue.popleft()
        if memo[1] != priorities[index]:
            queue.append(memo)
        else:
            if memo[0] == location:
                return answer + 1
            index += 1
            answer += 1
    return answer

print(solution([2, 1, 3, 2], 2))
print(solution([1, 1, 9, 1, 1, 1], 0))