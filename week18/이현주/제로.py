import sys

input = sys.stdin.read

data = input().strip().split()
loop = int(data[0])
stack = []
    
for i in range(1, loop + 1):
    num = int(data[i])
    if num != 0:
        stack.append(num)
    else:
        stack.pop()
    
sum_result = sum(stack)
print(sum_result)
