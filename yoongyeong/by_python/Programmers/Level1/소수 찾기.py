def solution(n):
    sosu = [True] * (n+1)
    for i in range(2, int((n+1)**0.5)+1):
        if sosu[i]:
            for j in range(i+i, n+1, i): sosu[j] = False
    return sosu.count(True)-2