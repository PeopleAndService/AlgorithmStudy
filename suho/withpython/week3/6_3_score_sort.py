"""
정렬
성적이 낮은 순서로 학생 출력하기
제한 : 1초 / 128MB
D 기업 프로그래밍 콘테스트 예선
"""

N = int(input())
scores = []
for _ in range(N):
    name, score = input().split()
    scores.append((name, int(score)))

scores.sort(key=lambda x: x[1])

for score in scores:
    print(score[0], end=' ')
