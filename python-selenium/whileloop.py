age = 10

while age < 18:
    print("You are still a minor and not eligible to vote at age " + str(age) + ".")
    age += 1  # Increment age to avoid infinite loop

print ("While loop completed.")