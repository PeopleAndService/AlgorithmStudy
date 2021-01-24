s = input()

alpha = []
num = 0

for i in s:
    if 65 <= ord(i) <= 90:
        alpha.append(i)
    else:
        num += int(i)

for a in range(len(alpha)):
    for b in range(a + 1, len(alpha)):
        if alpha[a] > alpha[b]:
            temp = alpha[a]
            alpha[a] = alpha[b]
            alpha[b] = temp

result = ''
for j in alpha:
    result += j

print(result, num, sep='')
