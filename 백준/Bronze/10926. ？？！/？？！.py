name = ""

while True:
    name = input()
    if len(name) > 50:
        print("input length must be lt 50")
    else:
        break

print(name+"??!")