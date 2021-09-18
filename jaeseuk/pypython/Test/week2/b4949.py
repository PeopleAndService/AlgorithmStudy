from sys import stdin

while True:
    string = stdin.readline().rstrip()

    if string == '.':
        break

    stack = []
    result = True

    for ch in string:
        if ch == '(' or ch == '[':
            stack.append(ch)
        elif ch == ')' or ch == ']':
            if not stack:
                result = False
                break
            elif ch == ')':
                if stack[-1] == '(':
                    stack.pop()
                else:
                    result = False
                    break
            else:
                if stack[-1] == '[':
                    stack.pop()
                else:
                    result = False
                    break

    if result and not stack:
        print('yes')
    else:
        print('no')
