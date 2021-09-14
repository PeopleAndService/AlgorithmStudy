from sys import stdin

string = stdin.readline().rstrip()
bomb = list(stdin.readline().rstrip())
size = len(bomb)
stack = []

for s in string:
    stack.append(s)

    if stack[-size:] == bomb:
        for _ in range(size):
            stack.pop()

if len(stack):
    print("".join(stack))
else:
    print("FRULA")
