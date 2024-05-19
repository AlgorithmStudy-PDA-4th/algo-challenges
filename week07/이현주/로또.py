def back(lotto, arr, start):
    for i in range(start, len(arr)):
        if len(lotto) >= 6:
            print(" ".join(map(str,result)))
            return
        if arr[i] not in lotto:
            lotto.append(arr[i])
            back(lotto, arr, i)
            lotto.pop()
    return

while True:
    inp = input()
    if inp == "0":
        break

    result = []
    input_line = list(map(int, inp.split()))
    size = input_line.pop(0)
    back(result, input_line, 0)

    print()
