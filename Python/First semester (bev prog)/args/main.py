import sys

argc = len(sys.argv)

print("parancssori arg. hossza: ",argc)

for i in range(1,argc):
    print("elem: ",sys.argv[i])

print("elérési útvonal: ",sys.argv[0])