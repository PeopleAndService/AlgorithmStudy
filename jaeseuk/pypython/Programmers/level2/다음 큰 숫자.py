def solution(n):
    start = bin(n)[2:].count('1')
    n += 1

    while start != bin(n)[2:].count('1'):
        n += 1

    return n
