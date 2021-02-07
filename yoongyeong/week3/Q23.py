# 국영수 (백준 10825, 핵심유형)

N = int(input())
student = []
for _ in range(N):
    student.append(input().split())

nStudent = sorted(student, key=lambda x : (-(int(x[1])), int(x[2]), -(int(x[3])), x[0]))

for i in range(N):
    print(nStudent[i][0])