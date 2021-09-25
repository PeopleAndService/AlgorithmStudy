from itertools import combinations

def solution(numbers):
    answer = set([sum(item) for item in combinations(numbers, 2)])
    return sorted(list(answer))