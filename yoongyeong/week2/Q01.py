# 모험가 길드
# 입력: 1) 모험가의 수 N, 2) 각 모험가의 공포도 값
# 출력: 1) 여행을 떠날 수 있는 그룹 수의 최댓값
import sys
N = int(input())
adventurer = list(map(int, sys.stdin.readline().rstrip().split()))
sorted(adventurer, reverse=True)

index_adventurer = result = 0
while True:
    if index_adventurer >= len(adventurer): break
    num = adventurer[index_adventurer]
    if index_adventurer + num >= len(adventurer): index_adventurer += 1
    else:
        result += 1
        index_adventurer += num

print(result)