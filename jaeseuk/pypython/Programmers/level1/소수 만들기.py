from itertools import combinations


def solution(nums):
    answer = 0
    prime = [True] * 3001

    for i in range(2, int(3000 ** 0.5) + 1):
        if prime[i]:
            j = 2

            while i * j <= 3000:
                prime[i * j] = False
                j += 1

    for combination in combinations(nums, 3):
        if prime[sum(combination)]:
            answer += 1

    return answer
