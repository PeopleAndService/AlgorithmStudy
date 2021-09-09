# 체육복

def solution(n, lost, reserve):
    students = [1] * n
    for l in lost:
        students[l-1] -= 1
    for r in reserve:
        students[r-1] += 1
    for i in range(n):
        if students[i] == 2:
            if i != 0 and students[i-1] == 0:
                students[i-1] += 1
            elif i != n-1 and students[i+1] == 0:
                students[i+1] += 1
            students[i] -= 1
    return sum(students)