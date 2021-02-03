import sys
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    score = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
    score.sort(key=lambda x: (x[0], x[1]))

    min_paper = score[0][0]
    min_speak = score[0][1]
    count = 0
    for paper, speak in score:
        if paper <= min_paper or speak <= min_speak:
            count += 1
            min_paper = min(min_paper, paper)
            min_speak = min(min_speak, speak)
    print(count)
