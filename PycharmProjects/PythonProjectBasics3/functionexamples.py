def compute_fibonacci_upto(maximum):
    """This function computes fibonacci numbers up to the maximum value provided.  It returns the list of fibonacci numbers up to the maximum value provided."""
    fibonacci_list = [0,1]
    i = 0;

    while fibonacci_list[-1] <= maximum:
        if i >= 1:
            fibonacci_list.append(fibonacci_list[-1] + fibonacci_list[-2])

        i+=1

    return fibonacci_list[0:len(fibonacci_list) - 1]

def computer_fibonacci_howmanytimes(value):
    """This function computes the fibonacci number sequence the number of times listed."""
    fibonacci_list = [0,1]

    if value <= 1:
        return fibonacci_list

    i = 0

    while i < value:
        if i >= 1:
            fibonacci_list.append(fibonacci_list[-1] + fibonacci_list[-2])
        i+=1

    return fibonacci_list


print(compute_fibonacci_upto(100000))
print(computer_fibonacci_howmanytimes(20))