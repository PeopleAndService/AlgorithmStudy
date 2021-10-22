def solution(s):
    cnt = 0

    for ch in s:
        if ch == '(':
            cnt += 1
        elif cnt == 0:
            return False
        else:
            cnt -= 1

    return cnt == 0
