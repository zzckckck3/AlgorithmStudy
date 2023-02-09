a, b, c = map(int, input().split())

while True:
    if 2<=a<=10000 or 2<=b<=10000 or 2<=c<=10000:
        break
    else:
        print("value must be 2<=val<=10000")

print((a+b)%c)
print(((a%c)+(b%c))%c)
print((a*b)%c)
print(((a%c)*(b%c))%c)