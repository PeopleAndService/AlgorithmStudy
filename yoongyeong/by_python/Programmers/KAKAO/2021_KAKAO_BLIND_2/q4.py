from itertools import combinations
from collections import deque

def solution(n, info):
    answer = [0] * 11
    lion_ac = [0] * 11
    lion_comb = []
    queue = deque([])
    apeach_score = 0
    for i, inf in enumerate(info):
        lion_ac[i] = inf+1
        if inf != 0: apeach_score += (10-i)
    for i in range(1, n):
        lion_comb += combinations([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], i)
    for comb in lion_comb:
        cnt_ac, sum_ac, apeach = 0, 0, 0
        for ac in comb:
            cnt_ac += lion_ac[10-ac]
            sum_ac += ac
            if info[10-ac] != 0: apeach += ac
        if sum_ac > (apeach_score-apeach) and cnt_ac <= n:
            queue.append([-(sum_ac-apeach_score+apeach), cnt_ac, list(comb)])
    s_queue = sorted(queue)
    if len(s_queue) == 0: return [-1]
    mini = s_queue[0][0]
    print(s_queue)
    for sss in s_queue:
        new_answer = [0] * 11
        if sss[0] != mini: break
        for ac in sss[2]:
            new_answer[10-ac] += lion_ac[10-ac]
        if sss[1] != n:
            new_answer[-1] += n - sss[1]
        for i in range(1, 11):
            if answer[-i] < new_answer[-i]:
                answer = new_answer
                break
            elif answer[-i] > new_answer[-i]:
                break

    return answer

print(solution(5, [2,1,1,1,0,0,0,0,0,0,0]))
print(solution(1, [1,0,0,0,0,0,0,0,0,0,0]))
print(solution(4, [0,0,4,0, 0,0,0,0,0,0,0]))