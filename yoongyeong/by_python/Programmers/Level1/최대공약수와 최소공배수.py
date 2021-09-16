from math import gcd
def solution(n, m):
    return [gcd(n, m), n*m//gcd(n, m)]