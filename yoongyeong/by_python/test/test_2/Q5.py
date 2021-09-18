# 1016번 제곱 ㄴㄴ수

def no_square(mini, maxi):
    numbers = [True] * (maxi - mini + 1)
    for i in range(2, int((maxi + 1) ** 0.5) + 1):
        for j in range(mini//(i**2)*(i**2), maxi + 1, i ** 2):
            if j >= mini and numbers[j-mini]: numbers[j-mini] = False
    return numbers.count(True)


mini, maxi = map(int, input().split())
print(no_square(mini, maxi))