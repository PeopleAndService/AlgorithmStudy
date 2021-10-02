def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    win_nums = {num: False for num in win_nums}
    match = 0
    zero = 0

    for lotto in lottos:
        if lotto in win_nums:
            match += 1
            win_nums[lotto] = True

        if lotto == 0:
            zero += 1

    answer = [rank[zero + match], rank[match]]
    return answer
