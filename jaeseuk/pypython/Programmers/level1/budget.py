def solution(d, budget):
    answer = 0
    d.sort()

    for price in d:
        """
        더 효율적일듯
        
        budget -= price
        if budget < 0:
            break
        answer += 1
        """
        if price <= budget:
            answer += 1
            budget -= price

    return answer
