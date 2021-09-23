def solution(lottos, win_nums):
    answer = 0
    for lotto in lottos:
        if lotto in win_nums: answer += 1
    if answer < 2 and (answer + lottos.count(0)) < 2: return [6, 6]
    elif answer < 2: return [7-answer-lottos.count(0),6]
    else: return [7-answer-lottos.count(0), 7-answer]