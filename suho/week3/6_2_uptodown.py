"""
정렬
위에서 아래로
제한 : 1초 / 128MB
T 기업 코딩 테스트
"""

N = int(input())
nums = []
for _ in range(N):
    nums.append(int(input()))

nums.sort(reverse=True)

for num in nums:
    print(num, end=' ')
