def solution(answers):
    one = [1, 2, 3, 4, 5]
    one_size = len(one)
    two = [2, 1, 2, 3, 2, 4, 2, 5]
    two_size = len(two)
    three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    three_size = len(three)

    people = [[0, 1], [0, 2], [0, 3]]
    max_score = 0

    for i in range(len(answers)):
        if one[i % one_size] == answers[i]:
            people[0][0] += 1

        if two[i % two_size] == answers[i]:
            people[1][0] += 1

        if three[i % three_size] == answers[i]:
            people[2][0] += 1

        max_score = max(max_score, people[0][0], people[1][0], people[2][0])

    answer = []

    for person in people:
        if person[0] == max_score:
            answer.append(person[1])

    return answer
