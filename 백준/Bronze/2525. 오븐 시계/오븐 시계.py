h, m = map(int, input().split())
p = int(input())

calm = h*60 + m + p

if calm >= 24*60:
    calm = calm - 24*60

print("{} {}".format(calm//60, calm - calm//60*60))
