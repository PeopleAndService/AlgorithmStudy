n = int(input())
result = [0] * n
result[0] = 1
idx = [0, 0, 0]

for i in range(1, n):
    result[i] = min(result[idx[0]] * 2, result[idx[1]] * 3, result[idx[2]] * 5)
    # 2의 배수 인덱스
    if result[i] == result[idx[0]] * 2:
        idx[0] += 1
    # 3의 배수 인덱스
    if result[i] == result[idx[1]] * 3:
        idx[1] += 1
    # 5의 배수 인덱스
    if result[i] == result[idx[2]] * 5:
        idx[2] += 1

print(result[n-1])
