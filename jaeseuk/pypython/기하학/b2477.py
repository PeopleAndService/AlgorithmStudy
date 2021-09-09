from sys import stdin

k = int(stdin.readline().rstrip())
data = [tuple(map(int, stdin.readline().rstrip().split())) for _ in range(6)]
max_width = [0, 0]
max_height = [0, 0]

for i in range(6):
    if data[i][0] == 1 or data[i][0] == 2:
        if max_width[1] < data[i][1]:
            max_width[1] = data[i][1]
            max_width[0] = i
    else:
        if max_height[1] < data[i][1]:
            max_height[1] = data[i][1]
            max_height[0] = i

min_width = abs(data[(max_width[0] + 1) % 6][1] - data[(max_width[0]) - 1 % 6][1])
min_height = abs(data[(max_height[0] + 1) % 6][1] - data[(max_height[0] - 1) % 6][1])

size = max_width[1] * max_height[1] - min_width * min_height

print(size * k)
