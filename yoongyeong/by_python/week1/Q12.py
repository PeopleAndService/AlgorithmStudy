# 기둥과 보 설치 (2020 카카오 신입공채)

def solution(n, build_frame):
    answer = []
    for i in range(len(build_frame)):
        x, y, a, isDelete = build_frame[i][0], build_frame[i][1], build_frame[i][2], build_frame[i][3]
        if isDelete == 0:  # 삭제
            answer.remove([x, y, a])
            if not test(answer):
                answer.append([x, y, a])
        else:  # 설치
            answer.append([x, y, a])
            if not test(answer):
                answer.remove([x, y, a])
    return sorted(answer)

def test(array):
    for i in range(len(array)):
        x, y, a = array[i][0], array[i][1], array[i][2]
        if a == 0:  # 기둥
            # 땅바닥에 붙어있거나, 보에 붙어있거나(왼쪽, 오른쪽), 밑에 기둥이 있거나 한 경우가 array에 있을때 ㄱㅊ
            if y == 0 or [x-1, y, 1] in array or [x, y, 1] in array or [x, y-1, 0] in array:
                continue
            else:
                return False
        elif a == 1:  # 보
            # 양쪽 보에 붙어있는 경우(동시에 붙어있기), 기둥 위에 위치한경우 (왼쪽, 오른쪽)가 array에 있을때 ㄱㅊ
            if ([x-1, y, 1] in array and [x+1, y, 1] in array) or [x, y-1, 0] in array or [x+1, y-1, 0] in array:
                continue
            else:
                return False
    return True
n = 5
build = [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
print("1번째 케이스", solution(n, build))
build1 = [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]
print("2번째 케이스", solution(n, build1))