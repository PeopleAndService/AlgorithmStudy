def solution(x):
    return x % sum([int(i) for i in str(x)]) == 0