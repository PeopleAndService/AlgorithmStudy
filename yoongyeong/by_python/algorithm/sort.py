def bubble_sort(sort_list):  # O(n^2)
    n = len(sort_list)
    for i in range(n - 1):
        for j in range(n-1, i, -1):
            if sort_list[j-1] > sort_list[j]: sort_list[j-1], sort_list[j] = sort_list[j], sort_list[j-1]
    return sort_list


def cocktail_sort(sort_list):
    a, b = 0, len(sort_list)
    swapped = True
    while swapped:
        swapped = False
        for i in range(a, b):
            if sort_list[i] > sort_list[i+1]: sort_list[i], sort_list[i+1] = sort_list[i+1], sort_list[i]; swapped = True
        if not swapped: break
        swapped = False

        b = b-1

        for i in range(b-1, a-1, -1):
            if sort_list[i] > sort_list[i+1]: sort_list[i], sort_list[i+1] = sort_list[i+1], sort_list[i]; swapped = True

        a = a + 1