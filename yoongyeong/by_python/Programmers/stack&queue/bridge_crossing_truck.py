# 다리를 지나는 트럭

from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer, sum_bridge = 0, 0
    trucks = deque(truck_weights)
    bridge = deque()
    while trucks:
        answer += 1
        if len(bridge) != 0:
            if bridge[0][1] + bridge_length == answer:
                sum_bridge -= bridge.popleft()[0]
        while sum_bridge + trucks[0] > weight:
            t_weight, t_time = bridge.popleft()
            answer += (t_time + bridge_length - answer)
            sum_bridge -= t_weight
        sum_bridge += trucks[0]
        bridge.append((trucks.popleft(), answer))
    return answer + bridge_length

print(solution(2, 10, [7,4,5,6]))
print(solution(100, 100, [10,10,10,10,10,10,10,10,10,10]))