def print_cycle(num):
    new_num = num[-1] + str(int(num[0]) + int(num[1]))[-1]
    if new_num == num:
        print(1)
        return

    cycle = 1
    while new_num != num:
        new_num = new_num[-1] + str(int(new_num[0]) + int(new_num[1]))[-1]
        cycle += 1

    print(cycle)
    return

num = input()

if int(num) < 10:
    num = '0' + num

print_cycle(num)
