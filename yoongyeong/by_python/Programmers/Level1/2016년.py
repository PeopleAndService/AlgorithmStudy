def solution(a, b):
    answer = ["THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"]
    months = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    days = sum(months[:a]) + b
    return answer[days % 7]

print(solution(2, 1))