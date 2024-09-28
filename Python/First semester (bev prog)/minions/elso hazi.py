import sys

def count_max():
    szamok = sys.argv[1:]
    maxok = 0
    for i in range(1, len(szamok)-1):
        if szamok[i] > szamok[i-1] and szamok[i] > szamok[i+1]:
            maxok += 1
    return maxok

def main():
    print(count_max())

if __name__== "__main__":
    main()