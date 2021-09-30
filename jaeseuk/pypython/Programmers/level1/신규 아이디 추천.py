import string


def solution(new_id):
    new_id = new_id.lower()
    available = string.digits + string.ascii_lowercase + '-_.'
    answer = []

    for ch in new_id:
        if ch in available:
            if answer and answer[-1] == '.' and ch == '.':
                continue
            elif not answer and ch == '.':
                continue
            else:
                answer.append(ch)

    if answer and answer[-1] == '.':
        answer.pop()

    if not answer:
        answer.append('a')

    if len(answer) >= 16:
        answer = answer[:15]

    if len(answer) <= 2:
        for _ in range(3 - len(answer)):
            answer.append(answer[-1])

    if answer[-1] == '.':
        answer.pop()

    return ''.join(answer)
