import random as r

def visszateres_lista(li:list) -> list:
    li = [r.randint(1,100)for _ in range(10)]
    return li

def feltolt(lista: list) -> None:
    for i in range(10):
        lista.append(r.randint(1,100))

def paros_elemek(li:list) -> int:
    n = 0
    for elem in li:
        if elem%2==0:
            n += 1

    return n


def main():
    # li = visszateres_lista()
    # print(li)
    li = []
    feltolt(li)
    print(li)
    print(paros_elemek(li))

if __name__ == "__name__":
    main()