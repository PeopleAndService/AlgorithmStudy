import sys
sys.setrecursionlimit(10000)


def find_valance_string(p):
    count = 0
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            count -= 1
        if count == 0:
            return i


def check_string(p):
    count = 0
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            if count == 0:
                # 열린 괄호 다 닫혔는데 ')'가 나옴
                return False
            count -= 1
    return True


def solution(p):
    answer = ''
    if p == '':
        return answer
    idx = find_valance_string(p)
    u = p[:idx + 1]
    v = p[idx + 1:]
    if check_string(u):
        answer = u + solution(v)
    else:
        answer = '('
        answer += solution(v)
        answer += ')'
        u = list(u)
        u.pop(0)
        u.pop(-1)
        for i in range(len(u)):
            if u[i] == ')':
                u[i] = '('
            else:
                u[i] = ')'
        answer += "".join(u)
    return answer


print(solution("()))((()"))
