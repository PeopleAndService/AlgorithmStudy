# 해시 - 위장 (L2)

def solution(clothes):
    person = {}
    cnt, result = 0, 1
    for clothe in clothes:
        if clothe[1] not in person.keys():
            person[clothe[1]] = 1
            cnt += 1
        else:
            person[clothe[1]] += 1
    if cnt == 1:
        return max(person.values())
    else:
        for p in person:
            if person[p] != 0:
                result *= (person[p]+1)
        return result - 1

print(solution([["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]))
print(solution([["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]))