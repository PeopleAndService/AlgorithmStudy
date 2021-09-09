def solution(s):
    answer = 0

    for i in range(1, len(s) + 1):
        std = s[:i]
        length = len(std)
        count = 0
        for c in range(i, len(s), i):
            com = s[c:c+i]
            if std == com:
                if count == 0:
                    length += 3
                    count += 1
                else:
                    count += 1
            else:
                length += len(com)
                std = com
                count = 0

        if answer == 0:
            answer += length
        elif answer > length:
            answer = length

    return answer
