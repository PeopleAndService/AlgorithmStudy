# 카펫

def solution(brown, yellow):
    for i in range(3, brown + yellow):
        if (brown + yellow) % i == 0:
            if (brown + yellow) == i * (brown / 2 + 2 - i):
                return [brown / 2 + 2 - i, i]