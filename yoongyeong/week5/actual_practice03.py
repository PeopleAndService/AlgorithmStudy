# 개미 전사

N = int(input())
food = list(map(int, input().split()))

food[2] += food[0]
for ant in range(3, N):
    food[ant] = max(food[ant - 2], food[ant - 3]) + food[ant]

print(max(food[-1], food[-2]))