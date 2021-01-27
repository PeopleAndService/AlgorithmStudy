# 기차가 어둠을 헤치고 은하수를
# 입력: 1) 기차의 수 N, 명령의 수 M 2) 명령들
# 출력: 은하수를 건널 수 있는 기차수

N, M = map(int, input().split())
trains = [[0] * 20 for _ in range(N)]

for _ in range(M):
    orders = list(map(int, input().split()))
    order, i = orders[0], orders[1] - 1
    if order == 1:
        trains[i][orders[2]-1] = 1
    elif order == 2:
        trains[i][orders[2]-1] = 0
    elif order == 3:
        trains[i] = [0] + trains[i][:19]
    else:
        trains[i] = trains[i][1:] + [0]
new_train = []
for train in trains:
    if train not in new_train: new_train.append(train)
print(len(new_train))
