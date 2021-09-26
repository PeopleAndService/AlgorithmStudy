def solution(board, moves):
    answer = 0
    size = len(board)
    board = [[board[j][i] for j in range(-1, -(size + 1), -1) if board[j][i]] for i in range(size)]
    basket = []

    for move in moves:
        if board[move - 1]:
            doll = board[move - 1].pop()

            if basket and basket[-1] == doll:
                basket.pop()
                answer += 1
            else:
                basket.append(doll)

    return answer * 2
