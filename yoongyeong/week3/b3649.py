# 로봇 프로젝트

while True:
    try:
        hole = int(input()) * 10000000
        lego_num = int(input())
        legos = [int(input()) for _ in range(lego_num)]
        legos.sort()
        start, end = 0, lego_num-1
        check = False
        while start < end:
            if legos[start] + legos[end] == hole:
                print("yes", legos[start], legos[end])
                check = True
                break
            elif legos[start] + legos[end] < hole:
                start += 1
            else:
                end -= 1
        if not check: print("danger")
    except:
        break
