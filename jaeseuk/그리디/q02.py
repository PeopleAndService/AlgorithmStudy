import sys

s = sys.stdin.readline().rstrip()

result = int(s[0])
for i in range(1, len(s)):
    num = int(s[i])
    if result > 1 and num > 1:
        result *= num
    else:
        result += num

print(result)
