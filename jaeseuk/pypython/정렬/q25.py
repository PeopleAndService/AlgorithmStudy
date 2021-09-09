def solution(N, stages):
    answer = [0] * (N + 1)
    players = len(stages)

    for stage in stages:
        if stage == N + 1:
            continue
        answer[stage] += 1

    fail = []
    for i in range(1, len(answer)):
        fail_rate = 0
        if answer[i] != 0:
            fail_rate = answer[i] / players

        fail.append((fail_rate, i))
        players -= answer[i]

    fail.sort(key=lambda x: (-x[0], x[1]))

    answer = []
    for f in fail:
        answer.append(f[1])

    return answer


print(solution(5, [1, 2, 2, 1, 3]))
