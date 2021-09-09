# 문자열 재정렬
# 입력: 1) 문자열 S
# 출력: 1) 알파벳은 오름차순 정렬, 숫자는 모두 더한 값

S = input()
S = sorted(S)

result = 0
for i in range(len(S)):
    if ord("9") >= ord(S[i]):
        result += int(S[i])
    else:
        print(S[i], end="")

print(result)