from itertools import combinations

def solution(nums):
    answer = 0
    for item in list(combinations(nums, 3)):
        answer += 1
        for i in range(2, sum(item)):
            if sum(item) % i == 0:
                answer -= 1
                break

    return answer