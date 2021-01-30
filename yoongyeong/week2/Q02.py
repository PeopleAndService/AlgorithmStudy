# 곱하기 혹은 더하기
# 입력: 1) 여러 개의 숫자로 구성된 하나의 문자열 S
# 출력: 1) 만들어질 수 있는 가장 큰 수

S = input()

result = int(S[0])

for i in range(1, len(S)):
    num = int(S[i])
    if result == 0 or result == 1 or num == 0 or num == 1:  # result <= 1 or num <= 1이라고 적으면 코드 간략화 가능
        result += num
    else: result *= num

print(result)