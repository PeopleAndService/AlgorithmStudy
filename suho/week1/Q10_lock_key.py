key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]


def rotate(input_list):
    size = len(input_list)
    res = [[0] * size for _ in range(size)]

    for i in range(size):
        for j in range(size):
            res[j][size-1-i] = input_list[i][j]

    return res


def solution(key, lock):
    answer = False

    M = len(key)
    N = len(lock)
    size = 2 * M + N

    key_lock = [[0] * size for _ in range(size)]

    # 자물쇠 대입
    for i in range(N):
        for j in range(N):
            key_lock[i+M][j+M] = lock[i][j]

    for i in range(M+N):
        for j in range(M+N):

            # 회전 케이스
            for _ in range(4):
                key = rotate(key)

                # 키 대입
                for k in range(M):
                    for l in range(M):
                        key_lock[i + k][j + l] += key[k][l]

                # 오픈 확인
                check_unlock = True

                for r in range(M, M + N):
                    for c in range(M, M + N):
                        if key_lock[r][c] == 1:
                            continue
                        else:
                            check_unlock = False
                            break

                if check_unlock:
                    answer = check_unlock
                else:
                    # 키 초기화
                    for k in range(M):
                        for l in range(M):
                            key_lock[i + k][j + l] -= key[k][l]

    return answer


print(solution(key, lock))
