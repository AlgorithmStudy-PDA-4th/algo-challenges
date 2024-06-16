alphabet = {}
for i in range(97, 123):
    alphabet[chr(i)] = 0

word = input()
for alpha in word:
    if alpha in alphabet.keys():
        alphabet[alpha] += 1

for i in alphabet.values():
    print(i, end=" ")
