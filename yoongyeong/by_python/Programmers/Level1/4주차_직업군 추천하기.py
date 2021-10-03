def solution(table, languages, preference):
    scores = []
    for t in table:
        t = t.split()
        score = 0
        for language, prefer in zip(languages, preference):
            if language in t:
                score += (6 - t.index(language)) * prefer
        scores.append((-score, t[0]))
    return sorted(scores)[0][1]