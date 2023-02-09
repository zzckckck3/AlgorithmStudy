nList = []

for i in range(10):
    n = int(input())
    r = n%42
    if r not in nList:
        nList.append(r)

print(len(nList))