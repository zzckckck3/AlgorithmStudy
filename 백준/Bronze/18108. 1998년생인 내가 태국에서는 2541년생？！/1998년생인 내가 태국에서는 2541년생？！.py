year = 0

while True:
    year = int(input())
    if year >= 1000 and year <= 3000:
        break
    else:
        print("input length must be 1000 <= y <= 3000")

print(year-543)