import sys

T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    size = n*m
    gold_map = list(map(int, sys.stdin.readline().rstrip().split()))
    result = [0] * size
    for i in range(0, m*(n-1), m):
        result[i] = gold_map[i]
    for c in range(m):
        for r in range(n):
            idx = r*m+c
            if r == 0:
                result[idx] = max(result[idx-1], result[idx+m-1]) + gold_map[idx]
            elif r == n-1:
                result[idx] = max(result[idx-m-1], result[idx-1]) + gold_map[idx]
            else:
                result[idx] = max(result[idx-m-1], result[idx-1], result[idx+m-1]) + gold_map[idx]
    print(max(result))
