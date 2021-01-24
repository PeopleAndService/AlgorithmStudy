# 외벽 점검(2020 카카오 신입 공채)

def solution(n, weak, dist):
    repair, friend = len(weak), len(dist)
    repair_list = [()]  # 현재까지 고칠 수 있는 leak의 위치
    friend_cnt = 0  # 투입친구 수
    dist.sort(reverse=True)

    for movement in dist:  # 고칠 수 있는 것들 리스트 작성
        new_repairs = []
        friend_cnt += 1
        for i, weak_point in enumerate(weak):  # 수리 가능한 지점 찾기
            start = weak_point
            ends = weak[i:] + [n + w for w in weak[:i]]
            do_repair = [end % n for end in ends if (end - start) <= movement]
            new_repairs.append(set(do_repair))

        possible_repair = set()
        for r in new_repairs:  # 수리 가능한 경우 탐색
            for x in repair_list:  # 기존 수리가능 지점
                new = r | set(x)  # 새로운 수리가능 목록 리스트
                if len(new) == repair:
                    return friend_cnt
                possible_repair.add(tuple(new))
        repair_list = possible_repair
    return -1


print("첫번째 예시", solution(12, [1, 5, 6, 10], [1, 2, 3, 4]))
print("두번째 예시", solution(12, [1, 3, 4, 9, 10], [3, 5, 7]))
print("세번째 예시", solution(200, [0, 10, 50, 80, 120, 160], [1, 10, 5, 40, 30]))
