def solution(s):
    numbers = sorted(map(int, s.split()))
    return str(numbers[0]) + " " + str(numbers[-1])
