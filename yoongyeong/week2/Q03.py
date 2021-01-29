# 문자열 뒤집기
# 입력: 1) 문자열 S
# 출력: 1) 행동의 최소 횟수

S = input()
x = int(S[0])
result = 1

for i in range(1, len(S)):
    num = int(S[i])
    if num != x:
        x = num
        result += 1

if result == 0:
    print(0)
else:
    print(result // 2)