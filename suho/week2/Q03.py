"""
그리디
문자열 뒤집기 (백준 1439번 실버5)
제한 : 2초 / 128MB
제출 : 68ms / 28776KB
"""

S = list(input())

zero_count = 0
one_count = 0

if S[0] == '0':
    zero_count += 1
if S[0] == '1':
    one_count += 1

for i in range(len(S) - 1):
    if S[i] == '1' and S[i + 1] == '0':
        zero_count += 1
    if S[i] == '0' and S[i + 1] == '1':
        one_count += 1

print(min(zero_count, one_count))
