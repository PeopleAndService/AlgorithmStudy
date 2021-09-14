def solution(N, stages):
    fail = [0] * (N + 1)
    answer = []

    for stage in stages:
        fail[stage - 1] += 1

    for i in range(len(fail) - 1):
        players = sum(fail[i:])

        if players > 0:
            answer.append((i + 1, fail[i] / players))
        else:
            answer.append((i + 1, 0))

    answer.sort(key=lambda x: (-x[1], x[0]))

    return list(map(lambda x: x[0], answer))
