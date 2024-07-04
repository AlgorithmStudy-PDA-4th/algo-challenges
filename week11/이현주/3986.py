n = int(input())
result = 0

for _ in range(n):
    stack = []
    _list = list(input())
    for i in _list:
        if not len(stack):
            stack.append(i)
        elif stack[-1] == i:
            stack.pop(-1)
        else:
            stack.append(i)

    if not len(stack):
        result += 1 

print(result)
