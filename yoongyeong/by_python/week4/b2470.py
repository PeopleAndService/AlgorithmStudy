# 두 용액 - 못품
import sys
input = sys.stdin.readline

N = int(input())
liquid = [int(x) for x in input().split()]
liquid.sort()
left = 0
right = N - 1
answer = liquid[left] + liquid[right]
al = left
ar = right
while left < right:
    tmp = liquid[left] + liquid[right]
    if abs(tmp) < abs(answer):
        answer = tmp
        al = left
        ar = right
        if answer == 0:
            break
    if tmp < 0:
        left += 1
    else:
        right -= 1
print(liquid[al], liquid[ar])