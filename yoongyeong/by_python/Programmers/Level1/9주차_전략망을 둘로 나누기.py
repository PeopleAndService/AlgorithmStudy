def solution(n, wires):
    answer = n
    for i in range(n-1):
        tops = dict()
        for wire in wires[:i]+wires[i+1:]:
            if str(wire[0]) in tops.keys(): tops[str(wire[0])].append(wire[1])
            else: tops[str(wire[0])] = [wire[1]]
            if str(wire[1]) in tops.keys(): tops[str(wire[1])].append(wire[0])
            else: tops[str(wire[1])] = [wire[0]]
        stack, visited = [1], {1}
        while stack:
            number = stack.pop()
            if str(number) in tops.keys(): stack.extend(list(set(tops[str(number)])-visited))
            visited.add(number)
        answer = min(answer, abs(n-len(visited)*2))
        if answer == 0: return answer
    return answer