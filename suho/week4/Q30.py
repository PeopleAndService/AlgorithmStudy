import bisect
#
#
# def find_start(list, key):
#     start = 0
#     end = len(list)
#     while start < end:
#         mid = (start + end) // 2
#         if list[mid] < key:
#             start = mid + 1
#         else:
#             end = mid
#     return start
#
#
# def find_end(list, key):
#     start = 0
#     end = len(list)
#     while start < end:
#         mid = (start + end) // 2
#         if key < list[mid]:
#             end = mid
#         else:
#             start = mid + 1
#     return start


def solution(words, queries):
    answer = []
    word = [[] for _ in range(10001)]
    reverse_word = [[] for _ in range(10001)]

    for item in words:
        word[len(item)].append(item)
        reverse_word[len(item)].append(item[::-1])

    for i in range(len(word)):
        word[i].sort()
        reverse_word[i].sort()

    for key in queries:
        length = len(key)
        if key[0] != '?':
            left_key = key.replace('?', 'a')
            right_key = key.replace('?', 'z')
            # start = find_start(word[length], left_key)
            # end = find_end(word[length], right_key)
            start = bisect.bisect_left(word[length], left_key)
            end = bisect.bisect_right(word[length], right_key)
            answer.append(end - start)
        else:
            left_key = key[::-1].replace('?', 'a')
            right_key = key[::-1].replace('?', 'z')
            # start = find_start(reverse_word[length], left_key)
            # end = find_end(reverse_word[length], right_key)
            start = bisect.bisect_left(reverse_word[length], left_key)
            end = bisect.bisect_right(reverse_word[length], right_key)
            answer.append(end - start)

    return answer


print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]))
