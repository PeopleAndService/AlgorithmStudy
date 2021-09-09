# 암기왕
import sys

def binary_search(array, target):
    start, end = 0, len(array)-1
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return True
        elif array[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return False


T = int(input())
for _ in range(T):
    N = int(input())
    note1 = list(map(int, sys.stdin.readline().rstrip().split()))
    M = int(input())
    note2 = list(map(int, sys.stdin.readline().rstrip().split()))
    note1.sort()

    for number in note2:
        if binary_search(note1, number):
            print(1)
        else:
            print(0)
