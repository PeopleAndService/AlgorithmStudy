def solution(x, n):
    if x > 0: return [i for i in range(x, x*n+1, x)]
    elif x == 0: return [0] * n
    else: return [i for i in range(x, x*n-1, x)]