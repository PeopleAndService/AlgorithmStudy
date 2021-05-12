"""
그리디
만들 수 없는 금액
제한 : 1초 / 128MB
K 대회 기출
"""

N = int(input())
coins = list(map(int, input().split()))


def check(num):
    start = num
    for coin in coins:
        if coin > start:
            continue
        else:
            start -= coin
            if start == 0:
                return True
    return False


for num in range(1, sum(coins) + 1):
    if not check(num):
        print(num)
        break
