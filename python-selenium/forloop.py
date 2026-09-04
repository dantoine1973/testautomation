for i in range(0,5,1):
    print("Iteration:", i)

list_of_items = ["apple", "banana", "cherry", "date", "elderberry"]

for j in list_of_items:
    print("Item:", j)
    if j == "cherry":
        print("Found cherry, breaking the loop.")
        break

sum = 0

for k in range(1, 11):
    print(k)
    sum += k

print(sum)