from sys import stdin

n, m = map(int, stdin.readline().rstrip().split())
po = dict()

for i in range(n):
    name = stdin.readline().rstrip()
    number = str(i + 1)
    po[number] = name
    po[name] = number

questions = [stdin.readline().rstrip() for _ in range(m)]

for question in questions:
    print(po[question])
