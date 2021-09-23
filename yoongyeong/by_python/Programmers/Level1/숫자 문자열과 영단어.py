def solution(s):
    answer = ""
    dictionary = {"z": [("zero", "0")], "o": [("one", "1")], "t": [("two", "2"), ("three", "3")],
                 "f": [("four", "4"), ("five", "5")], "s": [("six", "6"), ("seven", "7")],
                 "e": [("eight", "8")], "n": [("nine", "9")]}
    while s:
        if s[0].isdigit():
            answer += s[0]
            s = s[1:]
        else:
            for item in dictionary[s[0]]:
                if item[0] == s[:len(item[0])]:
                    answer += item[1]
                    s = s[len(item[0]):]
                    break
    return int(answer)


"""
def solution(s):
    words = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

    for i in range(len(words)):
        s = s.replace(words[i], str(i))

    return int(s)
"""