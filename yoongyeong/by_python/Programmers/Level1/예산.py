def solution(d, budget):
    group = sorted(d)
    for i in range(len(d), 0, -1):
        if sum(group[:i]) <= budget <= sum(group[-i:]): return i
        if sum(group[-i:])<=budget: return i # 그룹이 한개인 경우 생각 X
    return 0