allList = []

for i in range(30):
    allList.append(i+1)

for i in range(28):
    n = int(input())
    allList.remove(n)

for i in range(len(allList)):
    print(allList[i])