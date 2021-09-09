import sys

s = sys.stdin.readline().rstrip()

zero = 0
one = 0

for i in range(1, len(s)):
    if s[i] != s[i - 1]:
        if s[i] == '0':
            zero += 1
        else:
            one += 1

if s[-1] == '0':
    one += 1
else:
    zero += 1

print(min(zero, one))
# 처음 했던 코드
# zero = []
# one = []
#
# std = s[0]
# sec = [0]
# for i in range(1, len(s)):
#     if std == s[i]:
#         sec.append(i)
#     else:
#         if std == '0':
#             zero.append(sec)
#         else:
#             one.append(sec)
#         std = s[i]
#         sec = [i]
#
# print(min(len(zero), len(one)))
