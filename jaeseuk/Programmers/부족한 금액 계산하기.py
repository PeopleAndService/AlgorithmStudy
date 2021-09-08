def solution(price, money, count):
    answer = sum(map(lambda x: x * price, range(1, count + 1))) - money
    return answer if answer > 0 else 0
