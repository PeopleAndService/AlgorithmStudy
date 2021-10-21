def solution(A, B):
    A.sort()
    B.sort(reverse=True)

    answer = 0
    for a, b in zip(A, B):
        answer += a * b

    return answer
