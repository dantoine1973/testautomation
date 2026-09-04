# sample fibonacci loop

fibonacci = [0, 1]

i = 0

while fibonacci[-1] < 10000000000:
    if i > 1:
        fibonacci.append(fibonacci[i-1] + fibonacci[i-2])

    i += 1

print(fibonacci[-2])
print(fibonacci[-1])

