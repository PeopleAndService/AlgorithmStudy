N = int(input())
scores = []
for _ in range(N):
    name, kor, eng, mat = input().split()
    scores.append([name, int(kor), int(eng), int(mat)])

scores = sorted(scores, key=lambda x: (-x[1], x[2], -x[3], x[0]))

for score in scores:
    print(score[0])
