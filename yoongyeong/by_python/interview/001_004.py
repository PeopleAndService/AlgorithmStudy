def isPalindrome(str1):
    dic = dict()
    for char in str1:
        if char in dic: del dic[char]
        else: dic[char] = True
    return True if len(str1)%2 == len(dic) else False

