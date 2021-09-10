# 신규 아이디 추천

def solution(new_id):
    new_id1 = new_id.lower()
    new_id2, new_id3 = "", ""
    for n in new_id1:
        if ord("a")<=ord(n)<=ord("z") or ord("0")<=ord(n)<=ord("9") or n == "-" or n == "_" or n == ".":
            new_id2 += n
    flag = False
    for n in new_id2:
        if not flag and n == ".":
            flag = True
            new_id3 += n
        elif n != ".":
            flag = False
            new_id3 += n
    new_id456 = new_id3[:]
    if new_id3[0] == ".": new_id456 = new_id3[1:]
    if new_id3[-1] == ".": new_id456 = new_id456[:-1]
    if len(new_id456) == 0: new_id456 = "a"
    if len(new_id456) > 15:
        new_id456 = new_id456[:15]
        if new_id456[-1] == ".": new_id456 = new_id456[:-1]
    answer = new_id456[:]
    while len(answer) < 3:
        answer += new_id456[-1]

    return answer