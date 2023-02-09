n = int(input())

while True:
    if 1 <= n <= 4000:
        break
    else:
        print("input must be 1 <= n <= 4000")

if n % 4 == 0:
    if n % 400 == 0:
        print("1")
    elif n % 100 == 0:
        print("0")
    else:
        print("1")
else:
    print("0")