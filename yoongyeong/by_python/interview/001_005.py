def minus_one(str1, str2):
    dic = dict()
    for char1 in str1: dic[char1] = True
    for char2 in str2:
        if char2 in dic: del dic[char2]
        else: dic[char2] = True
    if len(str1) == len(str2): return True if len(dic) <= 2 else False
    else: return True if len(dic) <= 1 else False

print(minus_one("pale", "ple"))
print(minus_one("pales", "pale"))
print(minus_one("pale", "bale"))
print(minus_one("pale", "bake"))