def solution(arr):
    answer = [arr[0]]
    for a in arr:
        if a != answer[-1]: answer.append(a)
    return answer

### return [s[i] for i in range(len(s)) if s[i] != s[i+1:i+2]]