a, b, c = map(int, input().split())
winprize = 0
max = 0
if(a > max):
    max = a
if(b > max):
    max = b
if(c > max):
    max = c

if(a == b == c):
    winprize = 10000 + a*1000
elif(a == b):
    winprize = 1000 + a*100
elif(a == c):
    winprize = 1000 + a * 100
elif(b == c):
    winprize = 1000 + b * 100
else:
    winprize = max * 100

print(winprize)