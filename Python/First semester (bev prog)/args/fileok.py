with open("text.txt",encoding="utf-8") as file:
    # lines = file.read()
    # lines = file.readline()
    lines = file.readlines()
    # print(lines)
    for line in lines:
        print(line.strip("\n"))

with open("text.txt",'a',encoding="utf-8") as file:
    file.write("\nUjsor\n")

