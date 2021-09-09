# 가장 큰 수

def solution(numbers):
    str_num = [str(n) for n in numbers]
    str_num.sort(reverse=True)
    print(str_num)
    for i in range(len(numbers)-1):
        a, b = str_num[i], str_num[i+1]
        if a.startswith(b):
            if a != b and a[len(b)] < b[-1]:
                str_num[i], str_num[i+1] = b, a
    answer = "".join(str_num)
    if answer[0] == "0": return "0"
    return answer



# print(solution([3, 30, 34, 5, 9]))
print(solution([300, 31, 32, 3, 34]))