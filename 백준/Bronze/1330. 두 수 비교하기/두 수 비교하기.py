a, b = map(int, input().split())

while True:
    if -10000 <= a <= 10000 or -10000 <= b <= 10000:
        break
    else:
        print("input must be -10000<=input<=10000")

if(a > b):
    print(">")
elif(a < b):
    print("<")
else:
    print("==")