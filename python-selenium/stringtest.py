# String --> sequence of characters

str_1 = "David"
str_2 = "Joseph"
str_3 = "Antoine"

print(len(str_1))
print(len(str_2))
print(len(str_3))

print(str_1[1:4])

print(str_1 == str_2)
print(str_1 != str_3)
print(str_1 in str_3)

list_obj = str_1.split("v")

print(list_obj)