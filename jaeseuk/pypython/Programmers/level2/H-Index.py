def solution(citations):
    citations.sort()
    answer = citations[-1]

    while answer >= 0:
        up = 0
        down = 0
        for citation in citations:
            if citation >= answer:
                up += 1
            elif citation <= answer:
                down += 1

        if up >= answer >= down:
            break

        answer -= 1

    return answer
