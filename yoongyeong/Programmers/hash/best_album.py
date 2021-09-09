# 해시 - 베스트 앨범 (L3)
import operator


def solution(genres, plays):
    d_genres, d_plays = {}, {}
    answer = []
    for i in range(len(genres)):
        if genres[i] in d_genres:
            d_genres[genres[i]] += plays[i]
            d_plays[genres[i]].append((plays[i], -i))
        else:
            d_genres[genres[i]] = plays[i]
            d_plays[genres[i]] = [(plays[i], -i)]
    s_genres = sorted(d_genres.items(), reverse=True, key=operator.itemgetter(1))
    for s in s_genres:
        d_plays[s[0]].sort(reverse=True)
        for p in d_plays[s[0]][:2]:
            answer.append(-p[1])
    return answer

print(solution(["classic", "pop", "classic", "classic", "pop"],[500, 600, 150, 800, 2500]))