"""
그리디, 정렬
백준 1744 수 묶기 골드4
제한 : 2초 / 128MB
제출 : 64ms / 28776 KB
"""

N = int(input())
plus = []
minus = []
for _ in range(N):
    input_num = int(input())
    if input_num >= 1:
        plus.append(input_num)
    else:
        minus.append(input_num)

plus.sort(reverse=True)
minus.sort()
sum = 0
cnt = 0
tmp_sum = 0
for i in range(len(plus)):
    if cnt == 2:
        sum += tmp_sum
        cnt = 0
        tmp_sum = 0
    if plus[i] > 1:
        if cnt == 0:
            tmp_sum = plus[i]
            cnt += 1
        else:
            tmp_sum *= plus[i]
            cnt += 1
    if plus[i] == 1:
        sum += plus[i]
sum += tmp_sum
tmp_sum = 0
cnt = 0
for i in range(len(minus)):
    if cnt == 2:
        sum += tmp_sum
        cnt = 0
        tmp_sum = 0
    if minus[i] < 0:
        if cnt == 0:
            tmp_sum = minus[i]
            cnt += 1
        else:
            tmp_sum *= minus[i]
            cnt += 1
    if minus[i] == 0:
        tmp_sum *= minus[i]
        cnt += 1
sum += tmp_sum

print(sum)
