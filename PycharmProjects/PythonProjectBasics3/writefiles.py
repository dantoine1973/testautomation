with open('test1.txt','r') as reader:
    content = reader.readlines()
    with open('test2.txt', 'w') as writer:
        for line in reversed(content):
            writer.write(line)


