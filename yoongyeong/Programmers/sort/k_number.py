# k번째 수

def solution(array, commands):
    answer = []
    for command in commands:
        cut_array = array[command[0]-1:command[1]]
        cut_array.sort()
        answer.append(cut_array[command[2]-1])
    return answer