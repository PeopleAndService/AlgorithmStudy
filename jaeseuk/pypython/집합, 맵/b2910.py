from sys import stdin

n, c = map(int, stdin.readline().rstrip().split())
seq = list(map(int, stdin.readline().rstrip().split()))
freq = {}

for i in range(n):
    if seq[i] in freq:
        freq[seq[i]][1] += 1
    else:
        freq[seq[i]] = [i, 1]

seq.sort(key=lambda x: (-freq[x][1], freq[x][0]))

# print(*seq) 출력 결과 같음
for number in seq:
    print(number, end=' ')
