"""
최대 2명씩 밖에 못 타는거 못 보고 푼 코드..
from collections import deque


def solution(people, limit):
    people = deque(sorted(people, reverse=True))
    answer = 0

    while people:
        now = people.popleft()

        while people and people[-1] + now <= limit:
            now += people.pop()

        answer += 1

    return answer
"""


def solution(people, limit):
    people.sort()
    answer = 0

    start = 0
    end = len(people) - 1

    while start <= end:
        if people[start] + people[end] <= limit:
            start += 1

        end -= 1
        answer += 1

    return answer
