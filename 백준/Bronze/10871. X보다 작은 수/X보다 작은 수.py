import sys

a, b = map(int, sys.stdin.readline().split())
l = list(map(int, sys.stdin.readline().split()))

for i in range(a):
    if l[i] < b:
        print(l[i], end=" ")