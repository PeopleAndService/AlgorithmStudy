def solution(brown, yellow):
    total = brown + yellow
    answer = [0, 0]

    for i in range(3, total // 2 + 1):
        q, r = divmod(total, i)
        yq, yr = divmod(yellow, i - 2)

        if r == 0 and yq < q and yr == 0:
            answer[0], answer[1] = q, i
            break

    return answer
