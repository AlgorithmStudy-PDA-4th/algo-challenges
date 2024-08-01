from itertools import permutations

num_len = int(input())
nums = list(map(int, input().split()))
ops = list(map(int, input().split()))
ops_list = []
for i in range(4):
    if i == 0:
        ops_list += ['+']*ops[i]
    elif i == 1:
        ops_list += ['-']*ops[i]
    elif i == 2:
        ops_list += ['*']*ops[i]
    else:
        ops_list += ['/']*ops[i]

ops_order = list(set(permutations(ops_list, num_len-1)))
answer = [nums[0]] * len(ops_order)
for i in range(len(ops_order)):
    for j in range(num_len-1):
        if ops_order[i][j] == '+':
            answer[i] = answer[i] + nums[j+1]
        elif ops_order[i][j] == '-':
            answer[i] = answer[i] - nums[j+1]
        elif ops_order[i][j] == '*':
            answer[i] = answer[i] * nums[j+1]
        elif ops_order[i][j] == '/':
            if answer[i] < 0:
                answer[i] = -(-answer[i] // nums[j+1])
            else:
                answer[i] = answer[i] // nums[j+1]

print(max(answer))
print(min(answer))
