n, m = map(int, input().split())

arr = []
def back():
    for i in range(1, n + 1):
        if len(arr) >= m:
            print(" ".join(map(str, arr)))
            return

        if i not in arr:
            arr.append(i)
            back()
            arr.pop()

back()
