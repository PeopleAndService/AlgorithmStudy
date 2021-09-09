# 소수 찾기

import itertools
import math

def is_prime(number):
    flag = True
    if number != 0 and number != 1:
        for j in range(2, int(math.sqrt(number)) + 1):
            if number % j == 0:
                flag = False
    else: return False
    return flag


def solution(numbers):
    answer = set()
    numbers = sorted(list(numbers), reverse=True)
    for i in range(1, len(numbers)+1):
        for n in itertools.permutations(numbers, i):
            if is_prime(int("".join(n))):
                answer.add(int("".join(n)))
    return len(answer)

print(solution("011"))