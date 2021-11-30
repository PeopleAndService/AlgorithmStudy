from sys import stdin

n = int(stdin.readline().rstrip())
meetings = []

for _ in range(n):
    s, e = map(int, stdin.readline().rstrip().split())
    meetings.append((s, e))

meetings.sort(key=lambda x: (x[1], x[0]))

answer = 1
current = meetings[0]

for i in range(1, n):
    if current[1] <= meetings[i][0]:
        answer += 1
        current = meetings[i]

print(answer)
