def solution(n):
    changes = ''

    while n > 0:
        n, mod = divmod(n, 3)
        changes += str(mod)

    return int(changes, 3)

