"""
DP, 완전 탐색
퇴사 (백준 14051 실버4)
제한 : 2초 / 512MB
제출 : 64ms / 28776KB
삼성전자 SW 역량테스트
"""

n = int(input())
schedule = [list(map(int, input().split())) for _ in range(n)]
t = list(map(lambda x: x[0], schedule))
p = list(map(lambda x: x[1], schedule))
result = [0] * (n+1)
result[n] = 0
for i in reversed(range(n)):
    if i + t[i] > n:
        result[i] = result[i+1]
    else:
        result[i] = max(result[i+1], p[i]+result[i+t[i]])

print(result[0])
