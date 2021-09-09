# 전화번호 목록

t = int(input())

for _ in range(t):
    phone_directory = []
    n = int(input())
    check = False
    for _ in range(n):
        phone_directory.append(input())
    phone_directory.sort()
    for i, phone_num in enumerate(phone_directory):
        if i + 1 == len(phone_directory): break
        if phone_num in phone_directory[i+1][:len(phone_num)]:
            print("NO")
            check = True
            break
    if not check: print("YES")