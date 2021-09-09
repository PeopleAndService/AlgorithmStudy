# 신입 사원

T = int(input())
results = []
for test_case in range(T):
    N = int(input())
    result = 0
    applicant = []
    for _ in range(N):
        applicant.append(list(map(int, input().split())))
    applicant.sort()
    min_index = applicant[0][1]
    for i in range(1, N):
        if min_index > applicant[i][1]:
            min_index = applicant[i][1]
        else:
            result += 1
    results.append(N-result)

for i in results:
    print(i)