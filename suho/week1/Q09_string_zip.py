import sys

s = sys.stdin.readline().rstrip()


def solution(st):
    answer = len(st)
    step = 1
    while step <= len(st):
        count = 1
        result = ""

        for i in range(0, len(st), step):
            if st[i:i + step] == st[i + step:i + step + step]:
                count += 1
                continue
            else:
                if count == 1:
                    result += st[i:i + step]
                else:
                    result += (str(count) + st[i:i + step])
                count = 1

        answer = min(answer, len(result))
        step += 1

    return answer


print(solution(s))
