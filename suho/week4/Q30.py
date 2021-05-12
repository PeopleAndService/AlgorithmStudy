"""
이진 탐색
가사 검색
제한 : 1초 / 128MB
프로그래머스 2020 카카오 신입 공채 1차 레벨4
"""

import bisect


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
