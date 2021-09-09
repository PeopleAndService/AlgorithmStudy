# 문자열 뒤집기 (백준 1439)
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

if result == 1:
    print(0)
else:
    print(result // 2)

"""
--책풀이-- 비효율적인듯
data = input()
count0 = 0 # 전부 0으로 바꾸는 경우
count1 = 0 # 전부 1로 바꾸는 경우

if data[0] == '1':  # 첫 번째 원소에 대해서 처리
    count0 += 1
else:
    count1 += 1

for i in range(len(data) - 1):  # 두 번째 원소부터 모든 원소를 확인하며
    if data[i] != data[i + 1]:
        # 다음 수에서 1로 바뀌는 경우
        if data[i + 1] == '1': count0 += 1
        # 다음 수에서 0으로 바뀌는 경우
        else: count1 += 1

print(min(count0, count1))
"""