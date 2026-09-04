class BasicCalculator:

    def __init__(self,num1,num2):
        self.num1 = num1
        self.num2 = num2

    def add(self):
        return self.num1 + self.num2

    def subtract(self):
        return self.num1 - self.num2

    def multiply(self):
        return self.num1 * self.num2

    def divide(self):
        return self.num1 / self.num2

mycalc = BasicCalculator(10,5)

print(f"Addition: {mycalc.num1} + {mycalc.num2} = {mycalc.add()}")
print(f"Subtraction: {mycalc.num1} - {mycalc.num2} = {mycalc.subtract()}")
print(f"Multiplication: {mycalc.num1} * {mycalc.num2} = {mycalc.multiply()}")
print(f"Division: {mycalc.num1} / {mycalc.num2} = {mycalc.divide()}")