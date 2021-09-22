def solution(n, lost, reserve):
    lost = set(lost)
    reserve = set(reserve)
    lost, reserve = sorted(lost - reserve), sorted(reserve - lost)

    for student in reserve:
        for i in range(len(lost)):
            if student - 1 == lost[i] or lost[i] == student + 1:
                del lost[i]
                break

    return n - len(lost)
