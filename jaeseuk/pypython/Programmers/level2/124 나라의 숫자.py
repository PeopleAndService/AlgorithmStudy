def solution(n):
    r = ['1', '2', '4']
    answer = ''

    while n:
        nq, nr = divmod(n, 3)
        answer = r[nr - 1] + answer

        if nr == 0:
            nq -= 1

        n = nq

    return answer
