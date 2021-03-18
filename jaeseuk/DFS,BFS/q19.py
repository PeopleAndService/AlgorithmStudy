from sys import stdin

n = int(stdin.readline().rstrip())
data = list(map(int, stdin.readline().rstrip().split()))
opr_cnt = list(map(int, stdin.readline().rstrip().split()))
opr = ['+', '-', '*', '/']
# opr = ['+', '-', '*', '//']

result = []


def dfs(result, opr_cnt, expr, start):
    if start == n:
        result.append(int(expr))
        return

    temp = int(expr)
    for j in range(4):
        if opr_cnt[j] == 0:
            continue
        # if (opr[j] == '//') and (temp >= 0 and data[start] < 0):
        #     expr += opr[j] + str(-data[start])
        #     expr = str(-eval(expr))
        # elif (opr[j] == '//') and (temp < 0 and data[start] >= 0):
        #     expr = '-' + expr + opr[j] + str(data[start])
        #     expr = str(-eval(expr))
        # else:
        expr += opr[j] + str(data[start])
        # expr = str(eval(expr))
        expr = str(int(eval(expr)))
        opr_cnt[j] -= 1
        dfs(result, opr_cnt, expr, start + 1)
        expr = str(temp)
        opr_cnt[j] += 1


dfs(result, opr_cnt, str(data[0]), 1)
print(max(result))
print(min(result))
