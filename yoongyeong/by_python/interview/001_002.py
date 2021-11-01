# 순열 확인

def isPremutation(A, B):
    S_A, S_B = sorted(A), sorted(B)
    for index in range(len(S_A)):
        if S_A[index] != S_B[index]: return False
    return True