myfile = open("test1.txt", "r")

# myline = myfile.readline()
#
# while myline != '':
#     print(myline)
#     myline = myfile.readline()



for myline in myfile.readlines():
    print(myline)

myfile.close()
