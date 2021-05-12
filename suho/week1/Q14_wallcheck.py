"""
구현
외벽 점검
제한 : 1초 / 128MB
프로그래머스 2020 카카오 신입 공채 1차 레벨3
"""

# 답 봤음
from itertools import permutations

n = 12
weak = [1, 3, 4, 9, 10]
dist = [3, 5, 7]


def solution(n, weak, dist):
    length = len(weak)
    for i in range(length):
        weak.append(weak[i] + n)
    answer = len(dist) + 1

    for start in range(length):
        for friends in list(permutations(dist, len(dist))):
            count = 1
            end = weak[start] + friends[count-1]
            for idx in range(start, start + length):
                if end < weak[idx]:
                    count += 1
                    if count > len(dist):
                        break
                    end = weak[idx] + friends[count-1]
            answer = min(answer, count)
    if answer > len(dist):
        return -1
    return answer


print(solution(n, weak, dist))
