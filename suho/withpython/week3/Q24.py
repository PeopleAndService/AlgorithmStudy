"""
정렬, 그리디
안테나 (백준 18310 실버3)
제한 : 1초 / 256MB
제출 : 180ms / 51928KB
2019 SW 마에스트로 코딩 테스트
"""

# 시간초과 답 참고
# N = int(input())
# house = list(map(int, input().split()))
# dist = []
# for home in house:
#     sum = 0
#     for i in range(len(house)):
#         sum += abs(home - house[i])
#     dist.append((home, sum))
# dist.sort(key=lambda x: (x[1], x[0]))
# print(dist[0][0])

N = int(input())
home = list(map(int, input().split()))
home.sort()

print(home[(N-1)//2])
