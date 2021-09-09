def solution(scores):
    answer = ""
    new_scores = [[] for _ in range(len(scores))]

    for i in range(len(scores)):
        for j in range(len(scores)):
            new_scores[j].append(scores[i][j])

    for i in range(len(new_scores)):
        max_score = max(new_scores[i])
        min_score = min(new_scores[i])
        avg = sum(new_scores[i])

        if (new_scores[i].count(max_score) == 1 and new_scores[i][i] == max_score) or (
                new_scores[i].count(min_score) == 1 and new_scores[i][i] == min_score):
            avg = (avg - new_scores[i][i]) / (len(new_scores[i]) - 1)
        else:
            avg /= len(new_scores[i])

        if avg >= 90:
            answer += "A"
        elif avg >= 80:
            answer += "B"
        elif avg >= 70:
            answer += "C"
        elif avg >= 50:
            answer += "D"
        else:
            answer += "F"

    return answer
