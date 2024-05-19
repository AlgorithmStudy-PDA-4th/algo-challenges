l,c = map(int, input().split())
alpha_list = list(map(str, input().split()))
alpha_list.sort()
vowel_list = ['a', 'e', 'i', 'o', 'u'];

arr = []

def back(start, vowels, consonants):
    for i in range(start, c):
        if len(arr) >= l:
            if vowels < 1 or consonants < 2:
                return
            print("".join(map(str, arr)))
            return
        if alpha_list[i] not in arr:
            if alpha_list[i] in vowel_list:
                vowels += 1
            else:
                consonants += 1
            arr.append(alpha_list[i])
            back(i,vowels,consonants)
            alpha = arr.pop()
            if alpha in vowel_list:
                vowels -= 1
            else:
                consonants -= 1

back(0,0,0)
