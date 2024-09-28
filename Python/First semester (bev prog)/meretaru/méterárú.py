import sys

def vasarol(n,anyag,dict):


    if n < 0.5:
        print("ennyi anyagot nem lehet venni")
        return 0
    return int(dict[anyag]) *n


def main():
    name = sys.argv[1]
    with open(name, encoding="utf-8") as file:
        li = file.readlines() #van még a read meg a readline még
        li = [anyag.strip("\n").split(":") for anyag in li]
        anyagok_dict = {}
        for anyag in li:
            anyagok_dict[anyag[0]] = anyag[2] #anyag[0] a neve anyag[2] az ara

        #for nev,ertek in anyagok_dict.items():
        #    print(nev,ertek)
    anyag = input("Kerem az anyagot: ")
    n = int(input("Kérem a hosszt: "))
    print(vasarol(n, anyag, anyagok_dict))



if __name__=="__main__":
    main()