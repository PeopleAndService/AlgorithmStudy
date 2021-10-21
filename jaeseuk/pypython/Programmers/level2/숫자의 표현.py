def solution(n):
    answer = 1
    for i in range(1, n // 2 + 1):
        tmp = 0
        now = i
        while tmp < n:
            tmp += now

            if tmp == n:
                answer += 1
                break

            now += 1

    return answer
