from math import gcd


def solution(arr):
    if len(arr) == 1:
        answer = arr[0]
    else:
        answer = arr[0] * arr[1] // gcd(arr[0], arr[1])
        for i in range(2, len(arr)):
            answer = answer * arr[i] // gcd(answer, arr[i])

    return answer
