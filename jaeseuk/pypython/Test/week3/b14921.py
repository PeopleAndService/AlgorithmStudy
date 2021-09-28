from sys import stdin

"""
투 포인터 사용.
두 개의 합 중 절댓값이 가장 작은 값이 정답.
1. 양끝부터 시작해서 두 용액의 합을 구함.
2. 두 용액의 합과 answer의 절댓값이 작은 값을 저장.
3. 두 용액의 합이 음수라면 left 증가, 양수라면 right 증가
4. left가 right보다 작은 동안 반복.
"""

n = int(stdin.readline().rstrip())
liquid = list(map(int, stdin.readline().rstrip().split()))
answer = liquid[0] + liquid[-1]

left = 0
right = n - 1

while left < right:
    mix = liquid[left] + liquid[right]
    answer = min(answer, mix, key=abs)

    if mix < 0:
        left += 1
    else:
        right -= 1

print(answer)
