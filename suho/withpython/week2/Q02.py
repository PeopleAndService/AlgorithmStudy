"""
그리디
곱하기 혹은 더하기
제한 : 1초 / 128MB
페이스북 인터뷰
"""

S = list(map(int, list(input())))

result = 0
for num in S:
    # if num == 0 or result == 0: 1도 포함해야된다. 곱하면 자기 자신이니까!
    if num <= 1 or result <= 1:
        result += num
    else:
        result *= num

print(result)
