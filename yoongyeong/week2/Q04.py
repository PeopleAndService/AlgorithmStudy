# 만들 수 없는 금액 (답지 참고)
# 입력: 1) 동전의 개수 N, 2) 각 동전의 화폐단위를 나타내는 N개의 자연수
# 출력: 1) 만들 수 없는 양의 정수 금액 중 최솟값

import sys

N = int(input())
coin = list(map(int, sys.stdin.readline().rstrip().split()))

coin.sort()
result = 1

for c in coin:
    if result < c: break
    result += c

print(result)
