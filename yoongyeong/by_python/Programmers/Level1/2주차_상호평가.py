def solution(scores):
    answer = ''
    result = "FFFFFDDCBAA"
    students = [[] for _ in range(len(scores))]
    for score in scores:
        for i in range(len(score)): students[i].append(score[i])

    for i, score in enumerate(students):
        max_s, min_s = max(score), min(score)
        # 자기 자신을 평가한 점수가 유일한 최고점
        if max_s == score[i] and score.count(max_s) == 1:
            answer += result[(sum(score) - max_s) // (len(score) - 1) // 10]
        # 자기 자신을 평가한 점수가 유일한 최저점
        elif min_s == score[i] and score.count(min_s) == 1:
            answer += result[(sum(score) - min_s) // (len(score) - 1) // 10]
        else:
            answer += result[sum(score) // len(score) // 10]
    return answer

"""
리스트 뒤집기 : scores_transpose = zip(*scores)
"""