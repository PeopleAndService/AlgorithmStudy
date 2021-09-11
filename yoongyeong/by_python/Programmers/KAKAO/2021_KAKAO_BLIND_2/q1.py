def solution(id_list, report, k):
    answer = []
    users = {}
    bad_users = {}
    for id in id_list:
        users[id] = set()
        bad_users[id] = 0
    for rep in report:
        a, b = rep.split()
        users[a].add(b)

    for user in users.items():
        for bad in user[1]:
            bad_users[bad] += 1

    for user in users.items():
        cnt = 0
        for bad in user[1]:
            if bad_users[bad] >= k: cnt += 1
        answer.append(cnt)
    return answer


print(solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2))