def solution(sizes):
    mins, maxs = [], []
    for size in sizes: mins.append(min(size)); maxs.append(max(size))
    return max(mins)*max(maxs)