def solution(weights, head2head):
    # (전체 승률 높음, 몸무게 높은 사람 많이 이김, 내 몸무게 높음, 번호 작음)
    bocksers, answer = [], []
    for i, head in enumerate(head2head):
        win, heavy, war = 0, 0, 0
        for j, pan in enumerate(head):
            if pan == "W":
                win += 1; war += 1
                if weights[i] < weights[j]: heavy += 1
            elif pan == "L": war += 1
        bocksers.append((-win/war if war != 0 else 0, -heavy, -weights[i], i+1))
    for bockser in sorted(bocksers): answer.append(bockser[-1])
    return answer