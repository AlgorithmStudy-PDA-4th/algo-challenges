croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
word = input()

for alpha in croatia :
    word = word.replace(alpha, '*')
  
print(len(word))
