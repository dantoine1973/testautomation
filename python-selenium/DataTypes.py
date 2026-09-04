# Data Types in Python

a = 20
b = 24.5
c = "My bad!"
d = 'Too good!'
e = 10+3j

# List, Tuple, Dictionary examples

list_object = [0, 1, 1, 2, 3, 5, 8, 13]
tuple_object = (0, 1, 1, 2, 3, 5, 8, 13) ## immutable
dictionary_object = {"a": 20, "b": 24.5, "c": "My bad!", "d": "Too good!", "e": 10+3j}


print(str(a) + " " + str(b) + " " + c + " " + d + " " + str(e))

print(f"{a} {e}")

print(f"a is of type {type(a)}")
print(f"b is of type {type(b)}")
print(f"c is of type {type(c)}")
print(f"d is of type {type(d)}")
print(f"e is of type {type(e)}")

print(f"list_object {list_object} is of type {type(list_object)}")
print(f"tuple_object {tuple_object} is of type {type(tuple_object)}")
print(f"dictionary_object {dictionary_object} is of type {type(dictionary_object)}")
