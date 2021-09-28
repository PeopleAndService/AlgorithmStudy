import sys

input = sys.stdin.readline

k = int(input())
n = int(input())
final = list(map(str, input().strip()))
start = sorted(final)

left = 0
right = []

for _ in range(n):
    ladder = list(map(str, input().strip()))
    if ladder == ['?' for _ in range(k - 1)]:
        left = right
        right = []
        continue
    right.append(ladder)

while left:
    ladder = left.pop(0)
    for i in range(k - 1):
        if ladder[i] == '-': start[i], start[i + 1] = start[i + 1], start[i]

while right:
    ladder = right.pop()
    for j in range(k - 1):
        if ladder[j] == '-': final[j], final[j + 1] = final[j + 1], final[j]

ans = ['*' for _ in range(k - 1)]
for i in range(k - 1):
    if start[i] == final[i + 1] and start[i + 1] == final[i]:
        ans[i] = '-'
        start[i], start[i + 1] = start[i + 1], start[i]

if start != final: ans = ['x' for _ in range(k - 1)]
print(''.join(ans))