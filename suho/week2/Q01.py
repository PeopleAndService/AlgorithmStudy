N = int(input())
people = list(map(int, input().split()))
people.sort()

group = 0
cnt = 0

for person in people:
    cnt += 1
    if person == cnt:
        group += 1
        cnt = 0

print(group)
