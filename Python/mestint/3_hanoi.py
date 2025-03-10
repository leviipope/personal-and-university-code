class Hanoi_problema: # mindig a problémát modellezzük
    def __init__(self, ke, c):
        self.cel = c
        self.ke = ke
    # Konstruktor, két paramétert kér be, egy célállapotot és egy kezdőállapotot
    # ezeket a self.cel es self.ke-ben tárolja

    def celteszt(self, allapot):
        return allapot == self.cel
    # ez a metódus teszteli hogy elértük e a célállapotunkat

    def rakovetkezo(self, allapot):
        gyerekek = []     # listába lesznek tárolva a fa következő állapotai

        for melyiket in range(3):
            for hova in ['P', 'Q', 'R']: # beágyazott for ciklus: először kiválasztjuk a korongot, majd a azt hogy a hol lehet a korong (p q vagy r rúdon)
                alkalmazhato = True # előfeltétel vizsgálás
                if allapot[melyiket] != hova: # leellenőrzi hogy a korongot nem e akarjuk ugyanarra a helyre tenni, mivel allapot tomb melyiket eleme egy rud lesz, ahogy a hova is
                    for i in range(melyiket):
                        if allapot[i] != allapot[melyiket] and allapot[i] != hova:
                            alkalmazhato = True # ha az előfeltételek teljesülnek akkor alkalzható
                        else:
                            alkalmazhato = False # ha nem teljesülnek akkor hamis és breakeljünk ki
                            break
                else:
                    alkalmazhato = False
                    break # u.a.

                if alkalmazhato:
                    tmp = list(allapot)  # tuple to list conversion
                    tmp[melyiket] = hova # a lista melyikedik eleme lesz hogy hova rakjuk
                    uj_allapot = tuple(tmp) # uj allapotot tuplebe tároljuk
                    gyerekek.append(("semmi", uj_allapot))

        return gyerekek



if __name__ == "__main__":
    h = Hanoi_problema(('P','P','P'),('R','R','R'))
    print(h.rakovetkezo(('P','Q','R')))

