tmp = "0123456789ABCDEF"


def convert(num, base):
    q, r = divmod(num, base)

    if q == 0:
        return tmp[r]
    else:
        return convert(q, base) + tmp[r]


def solution(n):
    n = convert(n, 3)[::-1]
    return int(n, 3)