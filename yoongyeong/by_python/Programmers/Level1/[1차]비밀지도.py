def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        num = bin(arr1[i]|arr2[i])
        answer.append(" "*(n-len(num[2:]))+num[2:].replace("1", "#").replace("0", " "))
    return answer