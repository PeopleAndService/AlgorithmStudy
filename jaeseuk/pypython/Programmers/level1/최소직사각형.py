"""
그냥 큰값 중 최대랑 작은값 중 최대를 곱하면 되는 문제였음..
"""


def solution(sizes):
    width_max = max(sizes)[0]
    height_max = max(sizes, key=lambda x: x[1])[1]

    if width_max > height_max:
        height_max = 0
        for size in sizes:
            if width_max >= size[1] > size[0]:
                height = size[0]
            else:
                height = size[1]

            height_max = max(height_max, height)

    else:
        width_max = 0
        for size in sizes:
            if height_max >= size[0] > size[1]:
                width = size[1]
            else:
                width = size[0]

            width_max = max(width_max, width)

    return width_max * height_max
