def go_s(steps, tu):
    return [tu[0] + steps[tu[2]][0], tu[1] + steps[tu[2]][1], tu[2]]


def go_l(steps, tu):
    k = tu[2]
    if tu[2] == 0: k = 4
    return [tu[0] + steps[k - 1][0], tu[1] + steps[k - 1][1], k - 1]


def go_r(steps, tu):
    k = tu[2]
    if tu[2] == 3: k = -1
    return [tu[0] + steps[k + 1][0], tu[1] + steps[k + 1][1], k + 1]


def check_fin(size_x, size_y, x_y):
    n_x_y = [x_y[0], x_y[1], x_y[2]]
    if x_y[0] == -1:
        n_x_y[0] = size_x - 1
    elif x_y[0] == size_x:
        n_x_y[0] = 0
    elif x_y[1] == -1:
        n_x_y[1] = size_y - 1
    elif x_y[1] == size_y:
        n_x_y[1] = 0
    return n_x_y


def solution(grid):
    answer = []
    cycles = []
    steps = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    start = []
    for i in range(len(grid)):
        for j in range(len(grid[0])):
            start.append([i, j])
    if len(start) < 4: start *= 4
    for s in start:
        for i in range(4):
            recent = [s[0], s[1], i]
            cycle = []
            if grid[recent[0]][recent[1]] == "S":
                recent = go_s(steps, recent)
            elif grid[recent[0]][recent[1]] == "L":
                recent = go_l(steps, recent)
            elif grid[recent[0]][recent[1]] == "R":
                recent = go_r(steps, recent)
            recent = check_fin(len(grid), len(grid[0]), recent)
            cycle.append(recent)
            while [s[0], s[1], i] != recent:
                if grid[recent[0]][recent[1]] == "S":
                    recent = go_s(steps, recent)
                elif grid[recent[0]][recent[1]] == "L":
                    recent = go_l(steps, recent)
                elif grid[recent[0]][recent[1]] == "R":
                    recent = go_r(steps, recent)
                recent = check_fin(len(grid), len(grid[0]), recent)
                cycle.append(recent)
            cycles.append(cycle)
            print(cycle)
    n_list = []
    print("---------")
    for c in cycles:
        c.sort()
        print(c)
        if c not in n_list:
            n_list.append(c)
            answer.append(len(c))
    print("LL", n_list)
    return sorted(answer)

print(solution(["SLS", "LRS", "RLS"]))