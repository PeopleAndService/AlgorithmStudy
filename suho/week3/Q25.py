def solution(N, stages):
    answer = []
    user = len(stages)

    for i in range(1, N+1):
        stage_user = stages.count(i)

        # 0으로 나누는 오류 발생 할 수도 있어서 조건 하나 추가함
        if stage_user == 0 or user == 0:
            fail = 0
        else:
            fail = stage_user / user

        answer.append((i, fail))
        user -= stage_user

    answer.sort(key=lambda x: x[1], reverse=True)
    answer = [x[0] for x in answer]
    return answer


print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
