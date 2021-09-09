# 볼링공 고르기
# 입력: 1) 볼링공의 개수 N, 공의 최대 무개 M, 2) 볼링공의 무개 K
# 출력: 1) 두 사람이 볼링공을 고르는 경우의 수

from itertools import combinations
N, M = map(int, input().split())
K = list(map(int, input().split()))

array = list(combinations(K, 2))
result = len(array)
for i in array:
    if i[0] == i[1]:
        result -= 1
print(result)

"""
--책 풀이-- <내풀이는 조합의 수가 늘었을때, 최악의 경우 499500번 for 문 돔>
array = [0] * 11  # 1부터 10까지의 무게를 담을 수 있는 리스트
for x in K: array[x] += 1  # 각 무게에 해당하는 볼링공의 개수 카운트
result = 0
for i in range(1, M+1):
    N -= array[i]  # 무게가 i인 볼링공의 개수 제외
    result += array[i] * n  # B가 선택하는 경우의 수와 곱해주기
print(result)
"""