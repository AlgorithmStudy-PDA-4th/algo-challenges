import sys

left_stack = list(sys.stdin.readline().strip())
right_stack = []
cursor = len(left_stack)

op_num = int(sys.stdin.readline())
ops = [sys.stdin.readline().strip() for i in range(op_num)]
for op in ops:
    if op == 'L':
        if len(left_stack) > 0:
            right_stack.append(left_stack.pop())
            cursor -= 1
    elif op == 'D':
        if len(right_stack) > 0:
            left_stack.append(right_stack.pop())
            cursor += 1
    elif op == 'B':
        if len(left_stack) > 0:
            left_stack.pop(cursor-1)
            cursor -= 1
    else:
        left_stack.append(op[2])
        cursor += 1
        
print(''.join(left_stack+right_stack[::-1]))
