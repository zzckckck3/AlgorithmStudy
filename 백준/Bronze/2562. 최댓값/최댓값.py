nList = []
max = 0
whereMax = 0

for i in range(9):
    n = int(input())
    nList.append(n)

for i in range(len(nList)):
    if nList[i] > max:
        max = nList[i]
        whereMax = i + 1

print(max)
print(whereMax)
