fires = ["8", "10", "1", "200", "20", "2", "6"]
fire = ["8", "10", "1", "7", "4", "2", "6", "8", "10", "18", "22"]
test_case = int(input())
for _ in range(test_case):
    n = int(input())
    if n < 11: min_fire = fire[n]
    else: min_fire = fires[n%7] + "8" * ((n+6)//7-len(fires[n%7]))
    print(min_fire, "1" * (n//2) if n%2 ==0 else "7" + "1" * (n//2-1))