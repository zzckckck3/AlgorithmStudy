import sys

a = int(sys.stdin.readline())
list = []

for i in range(a):
    b, c = map(int, sys.stdin.readline().split())
    list.append(b+c)

for i in range(a):
    print(list[i])