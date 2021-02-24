# 금광

T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    gold = list(map(int, input().split()))

    for i in range(m - 1):
        for j in range(n):
            index = j * m + (m - 2 - i)
            if j == 0:
                max_gold = max(gold[index + m + 1], gold[index + 1])
            elif j == n - 1:
                max_gold = max(gold[index - m + 1], gold[index + 1])
            else:
                max_gold = max([gold[index - m + 1], gold[index + 1], gold[index + m + 1]])
            gold[index] += max_gold

    result = -1
    for i in range(n - 1):
        result = max(gold[m * i], result)

    print(gold)
    print(result)
