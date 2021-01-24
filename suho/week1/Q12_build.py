from collections import deque

test = [[1, 0, 0, 1], [1, 1, 1, 1], [2, 1, 0, 1], [2, 2, 1, 1], [5, 0, 0, 1], [5, 1, 0, 1], [4, 2, 1, 1],
        [3, 2, 1, 1]]

test2 = [[0, 0, 0, 1], [2, 0, 0, 1], [4, 0, 0, 1], [0, 1, 1, 1], [1, 1, 1, 1], [2, 1, 1, 1], [3, 1, 1, 1],
         [2, 0, 0, 0], [1, 1, 1, 0], [2, 2, 0, 1]]


# 컨디션 체크
def build_check(build, bow_start, bow_end, stick_end):
    start = (build[0], build[1])
    res = False
    # 기둥일 때
    if build[2] == 0:
        end = (build[0] + 0, build[1] + 1)
        if start[1] == 0 or start in stick_end or start in bow_end or start in bow_start:
            res = True
    else:
        # 보일 때
        end = (build[0] + 1, build[1] + 0)
        if (start in bow_end and end in bow_start) or start in stick_end or end in stick_end:
            res = True

    return res


def solution(n, build_frame):
    answer = []
    bow_start = []
    bow_end = []
    stick_start = []
    stick_end = []
    Q = deque(build_frame)
    while Q:
        work = Q.popleft()
        # 설치
        if work[3] == 1:
            start = (work[0], work[1])
            # 기둥
            if work[2] == 0:
                end = (work[0] + 0, work[1] + 1)
                if build_check(work, bow_start, bow_end, stick_end):
                    answer.append([work[0], work[1], work[2]])
                    stick_start.append(start)
                    stick_end.append(end)
                else:
                    continue
            else:
                # 보
                end = (work[0] + 1, work[1] + 0)
                if build_check(work, bow_start, bow_end, stick_end):
                    answer.append([work[0], work[1], work[2]])
                    bow_start.append(start)
                    bow_end.append(end)
                else:
                    continue
        else:
            # 삭제
            start = (work[0], work[1])
            # 기둥
            if work[2] == 0:
                end = (work[0] + 0, work[1] + 1)
                answer.remove([work[0], work[1], work[2]])
                stick_start.remove(start)
                stick_end.remove(end)
                avail = True
                for arc in answer:
                    if not build_check(arc, bow_start, bow_end, stick_end):
                        avail = False
                        break
                if not avail:
                    answer.append([work[0], work[1], work[2]])
                    stick_start.append(start)
                    stick_end.append(end)
                else:
                    continue
            else:
                # 보
                end = (work[0] + 1, work[1] + 0)
                answer.remove([work[0], work[1], work[2]])
                bow_start.remove(start)
                bow_end.remove(end)
                avail = True
                for arc in answer:
                    if not build_check(arc, bow_start, bow_end, stick_end):
                        avail = False
                        break
                if not avail:
                    answer.append([work[0], work[1], work[2]])
                    bow_start.append(start)
                    bow_end.append(end)
                else:
                    continue

    answer.sort(key=lambda x:(x[0], x[1], x[2]))
    return answer


print(solution(len(test), test))
