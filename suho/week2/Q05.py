"""
그리디
볼링공 고르기
제한 : 1초 / 128MB
2019 SW 마에스트로 코딩 테스트
"""

N, M = map(int, input().split())
balls = list(map(int, input().split()))
comb = []

for i in range(len(balls)):
    for j in range(i, len(balls)):
        if balls[i] == balls[j]:
            continue
        else:
            comb.append((i, j))

print(len(comb))
