# 만들 수 없는 금액
# 입력: 1) 동전의 개수 N, 2) 각 동전의 화폐단위를 나타내는 N개의 자연수
# 출력: 1) 만들 수 없는 양의 정수 금액 중 최솟값

import sys
N = int(input())
coin = list(map(int, sys.stdin.readline().rstrip().split()))

sorted(coin)
array = [0*sum(coin)]
for c in coin:
    array[c] = 1