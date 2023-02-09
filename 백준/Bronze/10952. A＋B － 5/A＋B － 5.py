import sys

l = []

while(True):
    a, b = map(int, sys.stdin.readline().split())
    if a == b == 0:
        break
    else:
        l.append(a+b)

for i in range(len(l)):
    print(l[i])