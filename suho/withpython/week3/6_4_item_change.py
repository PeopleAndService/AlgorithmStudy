"""
정렬
두 배열의 원소 교체
제한 : 2초 / 128MB
국제 알고리즘 대회
"""

N, K = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort()
B.sort(reverse=True)

for i in range(K):
    if B[i] > A[i]:
        A[i], B[i] = B[i], A[i]
    else:
        break

print(sum(A))
