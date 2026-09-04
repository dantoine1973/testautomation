def vote(age):
    match int(age):
        case _ if age >= 18 and age < 30:
            print("Apply ID card")
        case _ if age >= 30 and age < 60:
            print("You are eligible to vote.")
        case 60:
            print("You are eligible to vote as a senior citizen.")

def votevote(age):
    switcher = {18: "Apply ID card", 
                30: "You are eligible to vote.", 
                60: "You are eligible to vote as a senior citizen."}
    return switcher.get(age, "You are not eligible to vote.")

yourage = int(input("Enter your age: "))
vote(yourage)
print(votevote(yourage))