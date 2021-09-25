def solution(left, right):
    answer = 0
    primes = [1] * (right+1)
    for i in range(2, right+1):
        for j in range(i, right+1, i): primes[j] += 1
    for i in range(left, right+1):
        if primes[i] % 2 == 0: answer += i
        else: answer -= i
    return answer

