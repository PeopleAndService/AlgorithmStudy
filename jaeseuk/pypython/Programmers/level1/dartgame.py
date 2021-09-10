def solution(dartResult):
    section = {"S": 1, "D": 2, "T": 3}
    darts = []
    answer = []

    start = 0
    for i in range(len(dartResult)):
        if i == len(dartResult) - 1:
            darts.append(dartResult[start:i + 1])
        elif not dartResult[i].isdigit() and dartResult[i + 1].isdigit():
            darts.append(dartResult[start:i + 1])
            start = i + 1

    for i in range(len(darts)):
        if darts[i][1].isdigit():
            num = int(darts[i][:2]) ** section[darts[i][2]]
        else:
            num = int(darts[i][0]) ** section[darts[i][1]]

        if darts[i][-1] == "#":
            num *= -1
        elif darts[i][-1] == '*':
            num *= 2
            if i != 0:
                answer[i - 1] *= 2

        answer.append(num)

    return sum(answer)
