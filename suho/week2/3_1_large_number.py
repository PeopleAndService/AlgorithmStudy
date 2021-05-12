"""
그리디
큰 수의 법칙
제한 : 1초 / 128MB
2019 국가 교육기관 코딩 테스트
"""

import sys

N, M, K = map(int, sys.stdin.readline().rstrip().split())
numbers = list(map(int, sys.stdin.readline().rstrip().split()))
numbers.sort(reverse=True)
first_num = numbers[0]
second_num = numbers[1]

count = M // (K + 1)
div = M % (K + 1)
result = (first_num * K + second_num) * count + first_num * div

print(result)
