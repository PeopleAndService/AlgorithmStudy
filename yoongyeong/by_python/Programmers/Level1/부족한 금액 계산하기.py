def solution(price, money, count):
    return price * (count + 1) * count / 2 - money if price * (count + 1) * count / 2 > money else 0