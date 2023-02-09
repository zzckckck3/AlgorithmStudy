import sys

while True:
    try:
        b, c = map(int, sys.stdin.readline().split())
        print(b+c)
    except:
        break
