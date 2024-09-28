import sys

filename = sys.argv[1]

def euklideszi_alg(a: int, b: int) -> int:
    while a!=b:
        if(a>b):
            a -= b
        elif (b>a):
            b -= a
    return a

with open(filename,'r',encoding="utf-8") as szamok_file:
    szamok_lista = szamok_file.readlines()
    # print(szamok_lista)
    szamok_listak = [sor.strip() for sor in szamok_lista]
    # print(szamok_listak)

    for sor in szamok_listak:
        szamok = [int(n) for n in sor.split()]
        print(szamok)
        lnko = szamok[0]
        for i in range(1, len(szamok)):
            lnko = euklideszi_alg(lnko, szamok[i])
        print(lnko)