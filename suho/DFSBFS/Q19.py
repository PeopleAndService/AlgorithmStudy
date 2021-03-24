import sys

sys.setrecursionlimit(10000)

n = int(input())
array = list(map(int, sys.stdin.readline().rstrip().split()))
plus, minus, mul, div = map(int, input().split())

max_result = -10e9
min_result = 10e9


def dfs(num, cur_idx, plus_cnt, minus_cnt, mul_cnt, div_cnt):
    global max_result, min_result

    if cur_idx == n-1:
        max_result = max(num, max_result)
        min_result = min(num, min_result)
        return

    next = cur_idx + 1

    if plus_cnt > 0:
        dfs(num + array[next], next, plus_cnt-1, minus_cnt, mul_cnt, div_cnt)
    if minus_cnt > 0:
        dfs(num - array[next], next, plus_cnt, minus_cnt-1, mul_cnt, div_cnt)
    if mul_cnt > 0:
        dfs(num * array[next], next, plus_cnt, minus_cnt, mul_cnt-1, div_cnt)
    if div_cnt > 0:
        if num >= 0:
            dfs(num // array[next], next, plus_cnt, minus_cnt, mul_cnt, div_cnt-1)
        else:
            dfs(-(-num // array[next]), next, plus_cnt, minus_cnt, mul_cnt, div_cnt-1)


dfs(array[0], 0, plus, minus, mul, div)
print(max_result, min_result, sep='\n')
