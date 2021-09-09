# h_index

def solution(citations):
    citations.sort(reverse=True)
    for i in range(len(citations)):
        if citations[i] < (i+1):
            return i
    return len(citations)