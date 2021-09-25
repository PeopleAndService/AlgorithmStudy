def solution(participant, completion):
    answer = {}

    for name in participant:
        if name in answer:
            answer[name] += 1
        else:
            answer[name] = 1

    for name in completion:
        answer[name] -= 1

    for name in answer:
        if answer[name] != 0:
            return name
