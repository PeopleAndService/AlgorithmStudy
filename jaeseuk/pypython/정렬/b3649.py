import sys

while True:
    try:
        x = int(sys.stdin.readline().rstrip())
        n = int(sys.stdin.readline().rstrip())

        blocks = []
        for _ in range(n):
            blocks.append(int(sys.stdin.readline().rstrip()))

        blocks.sort()
        left = 0
        right = n - 1
        l1 = 0
        l2 = 0
        while left < right:
            result = blocks[left] + blocks[right]
            if result == (x * 10000000):
                l1, l2 = blocks[left], blocks[right]
                break
            elif result > (x * 10000000):
                right -= 1
            else:
                left += 1

        if l1 > 0 and l2 > 0:
            print('yes ' + str(l1) + ' ' + str(l2))
        else:
            print('danger')

    except EOFError:
        break
