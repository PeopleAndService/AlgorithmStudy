def solution(numbers, hand):
    answer = ''
    phone = [(1, 3), (0, 0), (1, 0), (2, 0), (0, 1), (1, 1), (2, 1), (0, 2), (1, 2), (2, 2)]
    left_part = {1, 4, 7}
    right_part = {3, 6, 9}
    left = (0, 3)
    right = (2, 3)

    for number in numbers:
        if number in left_part:
            answer += 'L'
            left = phone[number]
        elif number in right_part:
            answer += 'R'
            right = phone[number]
        else:
            now = phone[number]
            left_diff = abs(left[0] - now[0]) + abs(left[1] - now[1])
            right_diff = abs(right[0] - now[0]) + abs(right[1] - now[1])

            if left_diff < right_diff:
                answer += 'L'
                left = now
            elif left_diff > right_diff:
                answer += 'R'
                right = now
            elif hand == 'right':
                answer += 'R'
                right = now
            else:
                answer += 'L'
                left = now

    return answer
