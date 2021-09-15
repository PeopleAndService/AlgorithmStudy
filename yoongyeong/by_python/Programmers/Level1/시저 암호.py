def solution(s, n):
    answer = ""
    for i in s:
        if i.isalpha() and i.isupper():
            if ord(i) + n > ord("Z"):
                answer += chr(ord(i)+n-ord("Z")+ord("A")-1)
            else: answer += chr(ord(i)+n)
        elif i.isalpha():
            if ord(i) + n > ord("z"):
                answer += chr(ord(i) + n - ord("z") + ord("a")-1)
            else:
                answer += chr(ord(i) + n)
        else: answer += " "
    return answer