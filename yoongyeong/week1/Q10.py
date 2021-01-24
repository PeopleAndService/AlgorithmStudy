# 자물쇠와 열쇠(2020 카카오 신입공채)
import copy


def solution(key, lock):
    lenKey = len(key)
    lenLock = len(lock)
    answer = False
    for _ in range(4):
        key = rotation(key)
        for i in range(lenLock + lenKey - 1):
            for j in range(lenLock + lenKey - 1):
                sum_lock = copy.deepcopy(lock)
                for keyX in range(lenKey):
                    for keyY in range(lenKey):
                        if lenKey - 1 <= (i + keyX) < (lenKey + lenLock - 1) and lenKey - 1 <= (j + keyY) < (
                                lenKey + lenLock - 1):
                            sum_lock[i + keyX - lenKey + 1][j + keyY - lenKey + 1] += key[keyX][keyY]
                checkArray = [sum_lock[a][b] for a in range(lenLock) for b in range(lenLock) if sum_lock[a][b] == 1]
                if len(checkArray) == lenLock * lenLock:
                    return True
    return answer


def rotation(key):
    new_key = [[0 for _ in range(len(key))] for _ in range(len(key))]
    for i in range(len(key)):
        for j in range(len(key)):
            new_key[j][len(key[i]) - i - 1] = key[i][j]
    return new_key


print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))
