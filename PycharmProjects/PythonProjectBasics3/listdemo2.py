values = [1, 2, "hello", 3, 4, "awesome"]

# printing out items for values list

values.insert(3, "world")

values.append("cool")

values[2] = 'Hello'

for i in range(len(values)):
    print(values[i])

print(values[1:4])

del values[-1]

print(values)