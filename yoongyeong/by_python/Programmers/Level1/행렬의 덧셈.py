def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        ans = []
        for j in range(len(arr2[0])):
            ans.append(arr1[i][j]+arr2[i][j])
        answer.append(ans)
    return answer