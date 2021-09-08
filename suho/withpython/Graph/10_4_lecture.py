from collections import deque
import copy

n = int(input())
in_degree = [0] * (n+1)
graph = [[] for _ in range(n+1)]
time = [0] * (n+1)

for i in range(1, n+1):
    input_list = list(map(int, input().split()))
    time[i] = input_list[0]
    for j in input_list[1:-1]:
        in_degree[i] += 1
        graph[j].append(i)


def topology_sort():
    result = copy.deepcopy(time)
    q = deque()

    for i in range(1, n+1):
        if in_degree[i] == 0:
            q.append(i)

    while q:
        cur_node = q.popleft()
        for i in graph[cur_node]:
            result[i] = max(result[i], result[cur_node] + time[i])
            in_degree[i] -= 1
            if in_degree[i] == 0:
                q.append(i)

    for i in range(1, n+1):
        print(result[i])


topology_sort()
