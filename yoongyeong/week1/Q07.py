# 럭키 스트레이트 (백준 18406)
# 입력: 1) 점수 N
# 출력: 1) 사용가능하면 "LUCKY" 사용할 수 없으면 "READY"

N = input()
leftString = N[:len(N)//2]
rightString = N[len(N)//2:]
leftResult = 0
rightResult = 0
for i in range(len(leftString)):
    leftResult += int(leftString[i])
    rightResult += int(rightString[i])

if leftResult == rightResult:
    print("LUCKY")
else:
    print("READY")