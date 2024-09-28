import sys

argc = len(sys.argv)

print(sys.argv[0])
print("argumentumok szama:",argc)

prod = 1
for i in range(1,argc):
    prod *= int(sys.argv[i])

print("produktum",prod)
