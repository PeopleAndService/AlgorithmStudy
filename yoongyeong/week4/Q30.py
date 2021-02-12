# 가사 검색 (2020 카카오 신입 공채) // 스포당함
from bisect import bisect_left, bisect_right


def solution(words, queries):
    answer = []
    word_length = [[] for _ in range(10001)]
    r_word_length = [[] for _ in range(10001)]
    words.sort()
    for word in words:
        length = len(word)
        word_length[length].append(word)
        r_word_length[length].append(word[::-1])  # 문자열 뒤집을때 reverse 말고 [::-1]

    for i in range(10001):
        r_word_length[i].sort()

    for query in queries:
        if query[0] == "?":
            l_index = bisect_left(r_word_length[len(query)], query[::-1].replace("?", "a"))
            r_index = bisect_right(r_word_length[len(query)], query[::-1].replace("?", "z"))
            answer.append(r_index - l_index)
        else:
            l_index = bisect_left(word_length[len(query)], query.replace("?", "a"))
            r_index = bisect_right(word_length[len(query)], query.replace("?", "z"))
            answer.append(r_index - l_index)

    return answer


print(solution(["frodo", "front", "frost", "frozen", "frame", "kakao"], ["fro??", "????o", "fr???", "fro???", "pro?"]))

"""
def solution(words, queries):
    answer = []
    for query in queries:
        wild_card = query.count("?")
        word_card = len(query) - wild_card
        if query[0] == "?":
            answer.append(len([1 for word in words if len(word) == len(query) and word[wild_card:] == query[wild_card:]]))
        else:
            answer.append(len([1 for word in words if len(word) == len(query) and word[:word_card] == query[:word_card]]))
    return answer
"""
