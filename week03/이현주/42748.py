def solution(array, commands):
    answer = []
    for command in commands:
        sub_list = array[command[0]-1:command[1]]
        sub_list.sort()
        answer.append(sub_list[command[2]-1])
    return answer
