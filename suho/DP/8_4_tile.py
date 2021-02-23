N = int(input())
result = [0] * (N+1)
result[1] = 1
result[2] = 3

for i in range(3, N+1):
    result[i] = (result[i-2]*2 + result[i-1]) % 796796

print(result[N])
