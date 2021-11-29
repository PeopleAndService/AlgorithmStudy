from sys import stdin

n = int(stdin.readline().rstrip())
P = sorted(map(int, stdin.readline().rstrip().split()))
answer = P[0]

for i in range(1, n):
    P[i] += P[i - 1]
    answer += P[i]

print(answer)
