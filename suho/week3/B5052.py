"""
정렬, 문자열, 트라이
백준 5052 전화번호 목록 골드4
제한 : 1초 / 256MB
제출 : 420ms / 134224KB (PyPy3)
Python3 제출 시간초과 발생
"""

t = int(input())
for _ in range(t):
    n = int(input())
    tel = []
    for _ in range(n):
        tel.append(input())
    tel.sort()
    test = True
    for i in range(len(tel) - 1):
        if tel[i] in tel[i+1][:len(tel[i])]:
            test = False
            break
    if test:
        print('YES')
    else:
        print('NO')

    # for i in range(len(tel) - 1):
    #     for j in range(i + 1, len(tel)):
    #         if len(tel[j]) < len(tel[i]):
    #             continue
    #         if tel[j][:len(tel[i])] == tel[i]:
    #             test = False
    #             break
    #     if not test:
    #         break
    # if test:
    #     print('YES')
    # else:
    #     print('NO')