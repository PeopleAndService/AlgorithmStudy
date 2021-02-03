# 수 묶기

N = int(input())
negative_num = []
positive_num = []
results = []
is_zero = False

for i in range(N):
    num = int(input())
    if num < 0:
        negative_num.append(num)
    elif num > 0:
        positive_num.append(num)
    else: is_zero = True

negative_num.sort()
positive_num.sort(reverse=True)

for i in range(0, len(negative_num), 2):
    if i + 1 == len(negative_num):
        if not is_zero:
            results.append(negative_num[i])
        break
    results.append(negative_num[i] * negative_num[i + 1])

for i in range(0, len(positive_num), 2):
    if i + 1 == len(positive_num):
        results.append(positive_num[i])
        break
    if positive_num[i] == 1 or positive_num[i + 1] == 1:
        results.append(positive_num[i] + positive_num[i + 1])
    else:
        results.append(positive_num[i] * positive_num[i + 1])

print(sum(results))
