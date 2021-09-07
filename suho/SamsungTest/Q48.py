# import sys
# from collections import deque
#
# dr = [-1, 1, 0, 0]
# dc = [0, 0, -1, 1]
#
# n, m, k = map(int, input().split())
# sea = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
# shark_map = [[0] * n for _ in range(n)]
# for i in range(n):
#     for j in range(n):
#
#
# n by n 격자 m 칸에 상어 한마리 씩
# 모든 상어가 자신의 위치에 자신의 냄새를 뿌림 냄새는 k번 이동 후 소멸
# 1초마다 상어 이동
# 이동 우선순위
# 1. 냄새가 없는 칸의 방향
# 2. 자신의 냄새가 있는 칸의 방향
# 3. 여러 개라면 현재 방향에 따른 우선순위 정보
# 4. 이동한 방향이 보고있는 방향이 된다.
# 한 칸에 여러 마리의 상어가 남아있으면 가장 작은 번호를 가진 상어를 제외하고 아웃
