# 안테나 (백준 18310, 2019 SW 마에스트로 입학 테스트)

import sys
N = int(input())
houses = list(map(int, sys.stdin.readline().rstrip().split()))
print(sorted(houses)[(N - 1) // 2])

# N//2로 중간값 구할라고 삽질 엄청함
