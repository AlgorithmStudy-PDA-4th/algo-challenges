def solution(numbers, target):
    tree = [0]
    for i in range(len(numbers)) :
        value = []
        for j in range(len(tree)) :
            value.append(tree[j] - numbers[i])
            value.append(tree[j] + numbers[i])

        tree = value

    answer = tree.count(target)
    return answer
