n = input()

std = len(n) // 2
left = n[:std]
right = n[std:]

left_sum = 0
right_sum = 0

for i in left:
    left_sum += int(i)
for j in right:
    right_sum += int(j)

if left_sum == right_sum:
    print('LUCKY')
else:
    print('READY')