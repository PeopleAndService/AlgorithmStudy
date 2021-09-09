# 이중 우선순위 큐

import heapq


def solution(operations):
    maxh, minh, indexing = [], [], []
    answer = []
    index = 0
    for oper in operations:
        comment, num = oper.split()
        if comment == "I":
            heapq.heappush(maxh, (-int(num), index))
            heapq.heappush(minh, (int(num), index))
            indexing.append(0)
            index += 1
        elif num == "1":
            while maxh:
                numbers = heapq.heappop(maxh)
                if indexing[numbers[1]] == 0:
                    indexing[numbers[1]] = 1
                    break
        else:
            while minh:
                numbers = heapq.heappop(minh)
                if indexing[numbers[1]] == 0:
                    indexing[numbers[1]] = 1
                    break
    if len(maxh) == 0 or len(minh) == 0: return [0, 0]
    while maxh:
        numbers = heapq.heappop(maxh)
        if indexing[numbers[1]] == 0:
            answer.append(-numbers[0])
            break
    while minh:
        numbers = heapq.heappop(minh)
        if indexing[numbers[1]] == 0:
            answer.append(numbers[0])
            break
    return answer

print(solution(["I 7","I 5","I -5","D -1"]))