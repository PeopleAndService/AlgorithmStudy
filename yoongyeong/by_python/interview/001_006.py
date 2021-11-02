def compress_str(str1):
    compresses = [str1[0], 0]
    last = str1[0]
    for char in str1:
        if last == char: compresses[-1] += 1
        else:
            compresses[-1] = str(compresses[-1])
            last = char
            compresses.extend([char, 1])
    compresses[-1] = str(compresses[-1])
    return "".join(compresses) if len(compresses) <= len(str1) else str1

print(compress_str("aabccccaaa"))