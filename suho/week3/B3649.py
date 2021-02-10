import sys
while True:
    try:
        # 단위 통일
        x = int(sys.stdin.readline().rstrip()) * 10000000
        n = int(sys.stdin.readline().rstrip())
        blocks = []
        for _ in range(n):
            blocks.append(int(sys.stdin.readline().rstrip()))
        # 정렬 후 분할 탐색
        blocks.sort()
        left_index = 0
        right_index = n - 1
        enable = False
        while left_index < right_index:
            length = blocks[left_index] + blocks[right_index]
            if length == x:
                print('yes', blocks[left_index], blocks[right_index])
                enable = True
                break
            elif length > x:
                right_index -= 1
            else:
                left_index += 1
        if not enable:
            print('danger')
    except:
        break
