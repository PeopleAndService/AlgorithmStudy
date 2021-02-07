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
