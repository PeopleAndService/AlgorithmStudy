# 실패율 (카카오 신입 공채 1차)

def solution(N, stages):
    clear_stages = [[0, i] for i in range(N+2)]  # 0번째 인덱스는 안세고 -1번째 인덱스는 끝까지 클리어한 사용자
    stages.sort()
    user_cnt = len(stages)
    for user in stages:
        clear_stages[user][0] += 1
    for i in range(1, len(clear_stages)):
        if user_cnt == 0 : break
        clear_stages[i][0], user_cnt = clear_stages[i][0] / user_cnt, user_cnt - clear_stages[i][0]

    clear_stages.sort(key=lambda x: (-x[0], x[1]))
    print(clear_stages)
    answer = [clear_stages[i][1] for i in range(len(clear_stages)) if clear_stages[i][1] != 0 and clear_stages[i][1] != N+1]
    return answer


print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
print(solution(4, [4, 4, 4, 4, 4]))
