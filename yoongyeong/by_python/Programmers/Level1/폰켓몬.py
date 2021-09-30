def solution(nums):
    return len(set(nums)) if len(set(nums)) < len(nums) // 2 else len(nums) // 2

"""

def solution(nums):
    return min(len(nums)/2, len(set(nums)))
"""