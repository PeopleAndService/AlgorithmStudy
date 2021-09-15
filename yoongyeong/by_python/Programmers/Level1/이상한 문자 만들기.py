def solution(s):
    index, answer = 0, ""
    for ss in s:
        if ss == " ":
            index = 0
            answer += " "
        else:
            if index % 2 == 0: answer += ss.upper()
            else: answer += ss.lower()
            index += 1
    return answer

print(solution("try  hello world"))