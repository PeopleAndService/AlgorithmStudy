from sys import stdin

n, m = map(int, stdin.readline().rstrip().split())
not_listen = set()
not_see = set()

for _ in range(n):
    people = stdin.readline().rstrip()
    not_listen.add(people)

for _ in range(m):
    people = stdin.readline().rstrip()
    not_see.add(people)

not_listen_see = sorted(not_listen.intersection(not_see))

print(len(not_listen_see))
for people in not_listen_see:
    print(people)
