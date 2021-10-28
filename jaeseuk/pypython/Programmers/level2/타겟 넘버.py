def dfs(arr, t, total, order, answer):
    if order == len(arr):
        if total == t:
            return answer + 1
        else:
            return 0

    answer = dfs(arr, t, total + arr[order], order + 1, answer) + dfs(arr, t, total - arr[order], order + 1, answer)

    return answer


def solution(numbers, target):
    return dfs(numbers, target, 0, 0, 0)
