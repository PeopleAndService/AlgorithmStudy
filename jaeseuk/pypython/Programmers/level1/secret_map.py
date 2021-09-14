"""
비트 연산을 의도한 문제..
각 row마다 OR 연산한 것을 2진수로 바꾸고 rjust()나 zfill()로 0 채워주면 끝

def solution(n, arr1, arr2):
    answer = []
    for i,j in zip(arr1,arr2):
        a12 = str(bin(i|j)[2:])
        a12=a12.rjust(n,'0')
        a12=a12.replace('1','#')
        a12=a12.replace('0',' ')
        answer.append(a12)
    return answer
"""


def solution(n, arr1, arr2):
    answer = []

    for i in range(n):
        one = bin(arr1[i]).replace("0b", "")
        two = bin(arr2[i]).replace("0b", "")

        if len(one) < n:
            one = "0" * (n - len(one)) + one
        if len(two) < n:
            two = "0" * (n - len(two)) + two

        row = ""
        for j in range(n):
            if one[j] == "0" and two[j] == "0":
                row += " "
            else:
                row += "#"

        answer.append(row)

    return answer

