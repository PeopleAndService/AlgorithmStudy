def check(answer):
    for x, y, a in answer:
        if a == 0:
            if y != 0 and ([x, y - 1, a] not in answer and ([x, y, 1] not in answer and [x - 1, y, 1] not in answer)):
                return False
        else:
            if ([x, y - 1, 0] not in answer and [x + 1, y - 1, 0] not in answer) and ([x - 1, y, a] not in answer or [x + 1, y, a] not in answer):
                return False
    return True


def solution(n, build_frame):
    answer = []

    for x, y, a, b in build_frame:
        if b == 1:
            if x > n or y > n or (a == 1 and y == 0):
                continue
            else:
                answer.append([x, y, a])

                if not check(answer):
                    answer.remove([x, y, a])
        else:
            answer.remove([x, y, a])

            if not check(answer):
                answer.append([x, y, a])
    answer.sort(key=lambda k: (k[0], k[1], k[2]))  # 그냥 sort해도 되는건가?
    return answer
