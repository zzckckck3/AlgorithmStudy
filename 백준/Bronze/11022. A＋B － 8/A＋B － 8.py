import sys

a = int(sys.stdin.readline())
list1 = []
list2 = []
list3 = []

for i in range(a):
    b, c = map(int, sys.stdin.readline().split())
    list1.append(b)
    list2.append(c)
    list3.append(b+c)

for i in range(a):
    print("Case #{}: {} + {} = {}".format(i+1, list1[i], list2[i], list3[i]))