def solution(numbers, hand):
    left, right, answer = 9, 11, ""
    for number in numbers:
        num = number - 1 if number - 1 != -1 else 10
        i, j = num // 3, num % 3
        l_i, l_j, r_i, r_j = left // 3, left % 3, right // 3, right % 3

        if number in [1, 4, 7]:
            answer += "L"; left = num
        elif number in [3, 6, 9]:
            answer += "R"; right = num
        elif abs(l_i - i) + abs(l_j - j) > abs(r_i - i) + abs(r_j - j):
            answer += "R"; right = num
        elif abs(l_i - i) + abs(l_j - j) < abs(r_i - i) + abs(r_j - j):
            answer += "L"; left = num
        elif hand == "left":
            answer += "L"; left = num
        else:
            answer += "R"; right = num

    return answer