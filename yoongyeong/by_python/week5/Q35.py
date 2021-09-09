# 못생긴 수

array = [1, 2, 3, 5]

n = int(input())


while len(array) <= 1000:
    for number in array[:]:
        if not number * 2 in array:
            array.append(number * 2)
        if not number * 3 in array:
            array.append(number * 3)
        if not number * 5 in array:
            array.append(number * 5)

array.sort()
print(array[n-1])