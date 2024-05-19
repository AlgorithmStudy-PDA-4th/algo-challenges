n, m = map(int, input().split())
inputs = list(map(int, input().split()))
inputs.sort()

arr = []

def back():
    for i in inputs:
        if len(arr) >= m:
            print(" ".join(map(str, arr)))
            return
        if i not in arr:
            arr.append(i)
            back()
            arr.pop()

back()
