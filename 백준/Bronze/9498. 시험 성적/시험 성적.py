a = int(input())

while True:
    if 0 <= a <= 100:
        break
    else:
        print("input must be 0 <= input <= 100")

if 90 <= a <= 100:
    print("A")
elif a >= 80:
    print("B")
elif a >= 70:
    print("C")
elif a >= 60:
    print("D")
else:
    print("F")