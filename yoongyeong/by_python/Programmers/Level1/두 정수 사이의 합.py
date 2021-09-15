def solution(a, b):
    return sum([i for i in range(a, b + 1)]) if a<b else sum([i for i in range(b, a + 1)])

### return (abs(a-b)+1)*(a+b)//2
