# 카드 구매하기

n = int(input())
cards = list(map(int, input().split()))

for i in range(1, n):
    for j in range(1, (i + 1) // 2 + 1):
        if cards[i] < cards[j - 1] + cards[i - j]:
            cards[i] = cards[j - 1] + cards[i - j]

print(cards[-1])