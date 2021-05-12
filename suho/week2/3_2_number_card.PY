"""
그리디
숫자 카드 게임
제한 : 1초 / 128MB
2019 국가 교육기관 코딩 테스트
"""

import sys

N, M = map(int, sys.stdin.readline().split())
num_list = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
result = 0

for row in num_list:
    result = max(result, min(row))

print(result)
