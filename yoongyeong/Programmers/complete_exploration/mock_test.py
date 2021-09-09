# 모의고사
def solution(answers):
    answer = [[0, -1], [0, -2], [0, -3]]
    student1 = [1, 2, 3, 4, 5] * 8
    student2 = [2, 1, 2, 3, 2, 4, 2, 5] * 5
    student3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * 4

    index = 0
    for a in answers:
        if index == 40: index = 0
        if student1[index] == a:
            answer[0][0] += 1
        if student2[index] == a:
            answer[1][0] += 1
        if student3[index] == a:
            answer[2][0] += 1
        index += 1
    answer.sort(reverse=True)
    result = []
    maxi = answer[0][0]
    for a in answer:
        if a[0] != maxi: break
        result.append(-a[1])
    return result

print(solution([1, 3, 2, 4, 2]))
