h, m = map(int, input().split())

calm = h*60 + m - 45

if calm < 0:
    calm = calm + 24*60

print("{} {}".format(calm//60, calm - calm//60*60))
