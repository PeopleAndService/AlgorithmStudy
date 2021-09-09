from sys import stdin

n, k = map(int, stdin.readline().rstrip().split())
primes = [True] * (n + 1)

cnt = 0
result = 0
for i in range(2, n + 1):
    if result > 0:
        break

    if primes[i]:
        cnt += 1
        j = 2

        if cnt == k:
            result = i
            break

        while i * j <= n:

            if primes[i * j]:
                primes[i * j] = False
                cnt += 1

                if cnt == k:
                    result = i * j
                    break

            j += 1

print(result)
