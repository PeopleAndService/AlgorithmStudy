from collections import deque


def search_parents(parents, num, root):
    visited = deque([num])
    while visited[0] != root:
        visited.appendleft(parents[visited[0]])
    return visited


def solution(info, edges):
    sheeps, wolfs = [], []
    lock_tree = {}
    parents = [i for i in range(len(info))]
    queue = deque([0])
    for edge in edges:
        if str(edge[0]) in lock_tree.keys():
            lock_tree[str(edge[0])].append(edge[1])
        else:
            lock_tree[str(edge[0])] = [edge[1]]
        parents[edge[1]] = edge[0]
    all_sheep = info.count(0)
    while len(set(sheeps)) != all_sheep and queue:
        cnt = 1
        big_sheep_stack = []
        while queue:
            node = queue.popleft()
            if info[node] == 0:
                sheeps.append(node)
                if str(node) in lock_tree: queue.extend(lock_tree[str(node)])
                break
            elif cnt <= len(queue) + 1:
                stack = [node]
                queue.append(node)
                while stack:
                    n = stack.pop()
                    if info[n] == 0:
                        visited = search_parents(parents, n, node)
                        big_sheep_stack.append((len(visited), visited))
                        continue
                    if str(n) in lock_tree: stack.extend(lock_tree[str(n)])
            elif cnt > len(queue) + 1:
                if len(big_sheep_stack) == 0: break
                mini = min(big_sheep_stack)[1]
                if len(mini)-1+len(set(wolfs)) >= len(set(sheeps))+1:
                    return len(set(sheeps))
                for route in mini:
                    if info[route] == 0:
                        sheeps.append(route)
                    else:
                        wolfs.append(route)
                    if str(route) in lock_tree:
                        if lock_tree[str(route)][0] not in mini: queue.append(lock_tree[str(route)][0])
                        elif len(lock_tree[str(route)]) == 2: queue.append(lock_tree[str(route)][1])
                break
            cnt += 1

    return len(set(sheeps))

print(solution([0,0,1,1,1,0,1,0,1,0,1,1], [[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]))
print("__________________________")
print(solution([0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0],
               [[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6], [3, 7], [4, 8], [6, 9], [9, 10]]))
