"""
구현
문자열 재정렬
제한 : 1초 / 128MB
페이스북
"""

import sys

input_str = sys.stdin.readline().rstrip()

result = []
num_sum = 0

for character in input_str:
    if character.isalpha():
        result.append(character)
    else:
        num_sum += int(character)

result.sort()

if num_sum != 0:
    result.append(str(num_sum))

print("".join(result))
