def solution(table, languages, preference):
    table = [job.split() for job in table]
    answer = [0, ""]

    for job in table:
        score = 0
        for i in range(len(languages)):
            if languages[i] in job:
                score += (6 - job.index(languages[i])) * preference[i]

        answer = min(answer, [score, job[0]], key=lambda x: (-x[0], x[1]))

    return answer[1]
