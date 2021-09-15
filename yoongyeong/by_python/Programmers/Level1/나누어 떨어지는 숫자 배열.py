def solution(arr, divisor):
    answer = [a for a in arr if a % divisor == 0]
    return sorted(answer) if len(answer) != 0 else [-1]

### return sorted([n for n in arr if n%divisor == 0]) or [-1]
