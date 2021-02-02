import sys

n = int(sys.stdin.readline().rstrip())

sequence = []
for _ in range(n):
    sequence.append(int(sys.stdin.readline().rstrip()))

sequence.sort()

result = 0
left = 0
while left <= n - 1:
    if sequence[left] > 1:
        break
    elif sequence[left] == 0 or sequence[left] == 1:
        result += sequence[left]
        left += 1
    else:
        if left + 1 == n:
            result += sequence[left]
            break
        elif (sequence[left] < 0 and sequence[left + 1] < 0) or (sequence[left] < 0 and sequence[left + 1] == 0):
            result += sequence[left] * sequence[left + 1]
            left += 2
        else:
            result += sequence[left]
            left += 1

right = -1
while right >= left - n:
    if sequence[right] <= 1:
        break
    else:
        if right == -n:
            result += sequence[right]
            break
        elif sequence[right - 1] > 1:
            result += sequence[right] * sequence[right - 1]
            right -= 2
        else:
            result += sequence[right]
            right -= 1

print(result)
