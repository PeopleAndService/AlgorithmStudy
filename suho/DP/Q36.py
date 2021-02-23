A = input()
B = input()
n = len(A)
m = len(B)
res = [[0] * (m+1) for _ in range(n+1)]

# 최장 공통 부분 문자열
for i in range(1, n+1):
    res[i][0] = 0
for j in range(1, m+1):
    res[0][j] = 0
for i in range(1, n+1):
    for j in range(1, m+1):
        if A[i-1] == B[j-1]:
            res[i][j] = res[i-1][j-1] + 1
        else:
            res[i][j] = max(res[i-1][j-1], res[i-1][j], res[i][j-1])

print(len(B) - res[-1][-1])
