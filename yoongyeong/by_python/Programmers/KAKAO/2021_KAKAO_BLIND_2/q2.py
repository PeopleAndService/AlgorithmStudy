import math
import string

tmp = string.digits + string.ascii_lowercase


def convert(num, base):
    q, r = divmod(num, base)
    if q == 0:
        return tmp[r]
    else:
        return convert(q, base) + tmp[r]


def is_prime(number):
    flag = True
    if number != 0 and number != 1:
        for j in range(2, int(math.sqrt(number)) + 1):
            if number % j == 0:
                flag = False
    else:
        return False
    return flag


def solution(n, k):
    answer = 0
    numbers = list(str(convert(int(n), k)).split("0"))
    for num in numbers:
        if num != "":
            if is_prime(int(num)): answer += 1
    return answer

print(solution(110011, 10))