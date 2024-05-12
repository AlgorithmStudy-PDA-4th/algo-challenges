n, m = map(int, input().split())

arr = []

def back(start):
    for i in range(start,n+1):
        if len(arr) >= m:
            print(" ".join(map(str, arr)))
            return
        if i not in arr:
            arr.append(i)
            back(i)
            arr.pop()

back(1)
