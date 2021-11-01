# 중복이 없는가

def isDuplicate(str):
    hash = [False] * 52
    for char in str:
        index = ord(char) - ord("a")
        if hash[index]: return True
        hash[index] = True
    return False

string = "adkjfdspgjjsla"
print(isDuplicate("adkjfdspgjjsla"))
print(isDuplicate("asdfghjklmnbvcxz"))
print(True if len(string) - len(set(string)) > 0 else False)