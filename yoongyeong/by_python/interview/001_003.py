# URL 화

def changeURL1(str): return str.replace(" ", "%20")

def changeURL2(str):
    result = ""
    for char in str: result += char if char != " " else "%20"
    return result

print(changeURL2("Mr John Smith"))
print(changeURL1("Mr John Smith"))