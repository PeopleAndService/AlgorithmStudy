# 순위 검색

from bisect import bisect_left
from itertools import combinations


def make_cases(temp):
    cases = []
    for k in range(5):
        for li in combinations([0, 1, 2, 3], k):
            case = ''
            for idx in range(4):
                if idx not in li:
                    case += temp[idx]
                else:
                    case += '-'
            cases.append(case)
    return cases


def solution(info, query):
    answer = []
    all_people = {}
    for i in info:
        infos = i.split()
        cases = make_cases(i.split())

        for case in cases:
            if case not in all_people.keys():
                all_people[case] = [int(infos[4])]
            else:
                all_people[case].append(int(infos[4]))

    for key in all_people.keys():
        all_people[key].sort()

    for q in query:
        queries = q.split()
        target = queries[0] + queries[2] + queries[4] + queries[6]
        if target in all_people.keys():
            answer.append(len(all_people[target]) - bisect_left(all_people[target],
                                                                int(queries[7]), lo=0, hi=len(all_people[target])))
        else:
            answer.append(0)

    return answer


print(solution(
    ["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150",
     "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"],
    ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
     "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100",
     "- and - and - and - 150"]))
