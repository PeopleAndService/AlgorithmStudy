import sys

n = int(sys.stdin.readline().rstrip())

lines = []
for _ in range(n):
    lines.append(tuple(list(map(int, sys.stdin.readline().rstrip().split()))))

lines.sort()
max_y = sorted(lines, key=lambda x: x[1], reverse=True)[0][1]
max_length = max_y - lines[0][0]
gap = 0
last_y = lines[0][1]
for i in range(len(lines) - 1):
    if lines[i][0] == lines[i][1]:
        continue
    if last_y < lines[i + 1][0]:
        gap += lines[i + 1][0] - last_y
    last_y = lines[i + 1][1] if lines[i + 1][1] > last_y else last_y

result = max_length - gap
print(result)
