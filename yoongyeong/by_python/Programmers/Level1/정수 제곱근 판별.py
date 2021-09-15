from math import sqrt
def solution(n):
    return int(((sqrt(n))+1)**2) if sqrt(n) == int(sqrt(n)) else -1

print(solution(25))