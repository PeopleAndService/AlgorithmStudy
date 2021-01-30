S = list(map(int, list(input())))

result = 0
for num in S:
    # if num == 0 or result == 0: 1도 포함해야된다. 곱하면 자기 자신이니까!
    if num <= 1 or result <= 1:
        result += num
    else:
        result *= num

print(result)
