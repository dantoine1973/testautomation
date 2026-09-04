number = [1, 2, 3, 4]

def test_exception(a):
    try:
        print("Try block")
        divide = 20 / a
        print(divide)
    except ZeroDivisionError as e:
        print(e)
    else:
        print("Else block")
    finally:
        print("Out of loop")
        

test_exception(5)
test_exception(0)

if len(number) > 3:
    raise Exception("Number exception is raised")