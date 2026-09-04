# time to build a class in python
# classes are user-defined blueprints or prototypes

# building a calculator class with variables, methods, constructor (__init__)

class Calculator:
    arglist = dict()

    def __init__(self):
        arglist = dict(arg1='', operation='', arg2='')

    def getData(self):
        self.arglist['arg1'] = float(input("Give me a number: "))

        self.arglist['operation'] = input("What operation you want to do?: ")

        self.arglist['arg2'] = float(input("Give me another number: "))

        print(self.arglist)
        return self.arglist

    def computeData(self):

        if self.arglist['operation'] == '+':
            return (self.arglist['arg1'] + self.arglist['arg2'])
        elif self.arglist['operation'] == '-':
            return (self.arglist['arg1'] - self.arglist['arg2'])
        elif self.arglist['operation'] == '*':
            return (self.arglist['arg1'] * self.arglist['arg2'])
        elif self.arglist['operation'] == '/':
            return (self.arglist['arg1'] / self.arglist['arg2'])
        elif self.arglist['operation'] == '**':
            return (self.arglist['arg1'] ** self.arglist['arg2'])
        else:
            return ("Invalid operation")

myCalc = Calculator()

myCalc.getData()
print(myCalc.computeData())