from sys import stdin

s = set()
for _ in range(int(stdin.readline().rstrip())):
    operation = stdin.readline().rstrip().split()

    if operation[0] == 'add':
        s.add(int(operation[1]))
    elif operation[0] == 'remove':
        if int(operation[1]) in s:
            s.remove(int(operation[1]))
    elif operation[0] == 'check':
        if int(operation[1]) in s:
            print(1)
        else:
            print(0)
    elif operation[0] == 'toggle':
        if int(operation[1]) in s:
            s.remove(int(operation[1]))
        else:
            s.add(int(operation[1]))
    elif operation[0] == 'all':
        s = set(range(1, 21))
    else:
        s.clear()
