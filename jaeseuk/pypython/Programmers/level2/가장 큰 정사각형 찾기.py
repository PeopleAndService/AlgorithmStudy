def solution(board):
    answer = 0

    for i in range(1, len(board)):
        for j in range(1, len(board[i])):
            if board[i][j] == 1:
                board[i][j] = min(board[i][j - 1], board[i - 1][j], board[i - 1][j - 1]) + 1

    for i in range(len(board)):
        answer = max(answer, max(board[i]))

    return answer ** 2
