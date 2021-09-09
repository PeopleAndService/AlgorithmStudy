x, y, w, h = map(int, input().split())

result = min(x, w - x, y, h - y)
print(result)
