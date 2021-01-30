# 무지의 먹방 라이브(2019 카카오 신입공채)
# 효율성 테스트에 부분 점수가 있는 문제

def solution(food_times, k):
    n = len(food_times)
    index_array = [i for i in range(n)]
    while k // n != 0:
        eat = k // n
        k = k % n
        new_index_array = []
        for i in index_array:
            if food_times[i] <= eat:
                k += eat - food_times[i]
            else:
                new_index_array.append(i)
                food_times[i] -= eat
        index_array = new_index_array
        n = len(index_array)
        if n == 0: return -1
    return index_array[k] + 1


print(solution([3, 1, 2], 5))
print(solution([4, 2, 3, 6, 7, 1, 5, 8], 16))  # 3
print(solution([4, 2, 3, 6, 7, 1, 5, 8], 27))  # 5
print(solution([1, 1, 1, 1], 4))

"""
--책풀이--
import heapq

def solution(food_times, k):
    # 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
    if sum(food_times) <= k:
        return -1

    # 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
    q = []
    for i in range(len(food_times)):
        # (음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
        heapq.heappush(q, (food_times[i], i + 1))  

    sum_value = 0 # 먹기 위해 사용한 시간
    previous = 0 # 직전에 다 먹은 음식 시간
    length = len(food_times) # 남은 음식의 개수

    # sum_value + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
    while sum_value + ((q[0][0] - previous) * length) <= k:
        now = heapq.heappop(q)[0]
        sum_value += (now - previous) * length
        length -= 1 # 다 먹은 음식 제외
        previous = now # 이전 음식 시간 재설정

    # 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
    result = sorted(q, key=lambda x: x[1]) # 음식의 번호 기준으로 정렬
    return result[(k - sum_value) % length][1]
"""
