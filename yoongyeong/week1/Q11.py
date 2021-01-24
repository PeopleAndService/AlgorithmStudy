# 뱀 (백준 3190, 삼성전자 SW 역량테스트)
# 입력: 1) 보드 크기 N (정사각형) 2) 사과의 개수 K 3) 사과의 위치 (행, 열) 4) 뱀의 방향 변환 횟수 L  5) 뱀의 방향 변환 정보 (몇 초가 지났는지 K, 왼쪽 오른쪽 정보 C)
# 출력: 게임이 몇 초에 끝나는지
from collections import deque
N = int(input())
K = int(input())
dummy_map = [[0] * N for _ in range(N)]
for i in range(K):
    xPoint, yPoint = map(int, input().split())
    dummy_map[xPoint-1][yPoint-1] = 4
L = int(input())
turnArray = []
for i in range(L):
    turnArray.append(list(map(str, input().split())))
turnArray.append(["10001", "Finish"])
steps = [[0, 1], [1, 0], [0, -1], [-1, 0]]
dummy_map[0][0] = 1
x = y = 0
result_time = 0
turn_index = 0
step_index = 0
snake = deque([[0, 0]])
while True:
    if result_time == int(turnArray[turn_index][0]):
        if turnArray[turn_index][1] == "D":
            step_index += 1
            if step_index == 4: step_index = 0
        else:
            step_index -= 1
            if step_index == -1: step_index = 3
        turn_index += 1
        continue
    new_x = x + steps[step_index][0]
    new_y = y + steps[step_index][1]
    result_time += 1
    if not 0 <= new_x < N or not 0 <= new_y < N:  # 벽에 닿을때
        break
    elif dummy_map[new_x][new_y] == 1:  # 자기 몸에 닿을때
        break
    elif dummy_map[new_x][new_y] == 0:
        new_array = snake.popleft()
        dummy_map[new_array[0]][new_array[1]] = 0
    x, y = new_x, new_y
    snake.append([x, y])
    dummy_map[x][y] = 1

print(result_time)
