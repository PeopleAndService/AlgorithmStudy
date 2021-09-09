# 문자열 압축 (2020 카카오 신입 공채)
def solution(s):
    answer = 1e9
    i = len(s)//2
    if i == 0:
        answer = 1
    while i != 0: #500번 돔
        sizeResult = 0
        array = []
        for j in range(len(s) // i):
            array.append(s[j*i:(j+1)*i])
        if len(s) % i != 0:
            array.append(s[len(s) // i * i :])
        string = ""
        cnt = 1
        for j in range(len(array)):
            if string == array[j]:
                cnt += 1
                if j+1 == len(array):
                    sizeResult += len(str(cnt))
            else:
                string = array[j]
                sizeResult += len(string)
                if cnt != 1:
                    sizeResult += len(str(cnt))
                cnt = 1
        answer = min(answer, sizeResult)
        i -= 1
    return answer

print("결과", solution("aaaaa"))