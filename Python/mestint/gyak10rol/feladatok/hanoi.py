from keres import *


class Hanoi_problema (Feladat):
    def __init__(self, ke, c):
        self.cél = c
        self.kezdő = ke

    def célteszt(self, allapot):
        return allapot == self.cél

    def rákövetkező(self, allapot):
        gyerekek = []

        for melyiket in range(3):
            for hova in ['P', 'Q', 'R']:
                alkalmazhato = True
                if allapot[melyiket] != hova:
                    for i in range(melyiket):
                        if allapot[i] != allapot[melyiket] and allapot[i] != hova:
                            alkalmazhato = True
                        else:
                            alkalmazhato = False
                            break
                else:
                    alkalmazhato = False

                if alkalmazhato:
                    tmp = list(allapot)
                    tmp[melyiket] = hova
                    uj_allapot = tuple(tmp)
                    gyerekek.append((f"{melyiket+1}-->{hova}", uj_allapot))

        return gyerekek


def heurisztika(csúcs):
    allapot = csúcs.állapot
    cel = ('R', 'R', 'R')  # The goal state from the example
    
    # Count the number of disks not in their goal position
    return sum(1 for i in range(len(allapot)) if allapot[i] != cel[i])


if __name__ == "__main__":
    h = Hanoi_problema(('P','P','P'),('R','R','R'))
    #csúcs = szélességi_fakereső(h)
    #csúcs = mélységi_fakereső(h)
    csúcs = best_first(h, heurisztika)
    út = csúcs.út()
    út.reverse()
    print(út)
    print(len(csúcs.út()))
    print(csúcs.megoldás())

