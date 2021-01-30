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
