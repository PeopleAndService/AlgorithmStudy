# 정수 삼각형 (백준 1932)

n = int(input())
triangle = []
for i in range(n):
    triangle.append(list(map(int, input().split())))

for i in range(n - 1):
    line = triangle[n - i - 1]
    for j in range(len(line) - 1):
        triangle[n - i - 2][j] += max(line[j], line[j+1])

print(triangle[0][0])
