# 치킨 배달 (백준 15686, 삼성전자 SW 역량 테스트)
# 입력: 1) 도시의크기 N(정사각형), 최대 치킨집 갯수 M 2) 도시의 정보(0 빈칸 1 집 2 치킨집)
# 출력: 도시의 치킨거리 최솟값

import sys
from itertools import combinations

N, M = map(int, input().split())
city_map = []
for i in range(N):
    array = list(map(int, sys.stdin.readline().rstrip().split()))
    city_map.append(array)

houses = []
chickenHouse =[]

for i in range(N):
    for j in range(N):
        if city_map[i][j] == 1:
            houses.append([i, j])
        elif city_map[i][j] == 2:
            chickenHouse.append([i, j])

chik = [i for i in range(len(chickenHouse))]
select_chik = list(combinations(chik, M))

answer = 1e9
for i in range(len(select_chik)):
    sum_chiks = 0
    for j in range(len(houses)):
        distance = 1e9
        for k in range(M):
            a = abs(houses[j][0] - chickenHouse[select_chik[i][k]][0]) + abs(houses[j][1] - chickenHouse[select_chik[i][k]][1])
            distance = min(distance, a)
        sum_chiks += distance
    answer = min(answer, sum_chiks)
print(answer)