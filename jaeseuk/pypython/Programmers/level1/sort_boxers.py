def solution(weights, head2head):
    answer = []

    for idx, player in enumerate(zip(weights, head2head)):
        game = len(player[1]) - player[1].count("N")
        win = player[1].count("W") / game if game > 0 else 0
        cnt = 0

        for i in range(len(player[1])):
            if idx != i and player[1][i] == "W" and player[0] < weights[i]:
                cnt += 1

        answer.append((idx + 1, win, cnt, player[0]))

    answer.sort(key=lambda x: (-x[1], -x[2], -x[3], x[0]))
    return list(map(lambda x: x[0], answer))
