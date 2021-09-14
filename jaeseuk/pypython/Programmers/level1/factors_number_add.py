"""
math.sqrt 대신 num ** 0.5 가능
"""

import math


def cnt(num):
    cnt = 0

    for i in range(1, int(math.sqrt(num)) + 1):
        q, r = divmod(num, i)

        if r == 0:
            if q != i:
                cnt += 2
            else:
                cnt += 1

    return cnt


def solution(left, right):
    answer = 0

    for i in range(left, right + 1):
        answer += i if cnt(i) % 2 == 0 else -i

    return answer
