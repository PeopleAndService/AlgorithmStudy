# 메뉴 리뉴얼
from itertools import combinations
import operator

def solution(orders, course):
    answer = []
    for c in course:
        food = {}
        for order in orders:
            for combi in combinations(list(order), c):
                s_combi = tuple(sorted(combi))
                if s_combi in food:
                    food[s_combi] += 1
                else:
                    food[s_combi] = 1
        sfood = sorted(food.items(), key=operator.itemgetter(1), reverse=True)
        print(sfood)
        for s in sfood:
            if s[1] == sfood[0][1] and s[1] != 1:
                answer.append("".join(list(s[0])))
            else: break

    return sorted(answer)

print(solution(	["XYZ", "XWY", "WXA"], [2, 3, 4]))