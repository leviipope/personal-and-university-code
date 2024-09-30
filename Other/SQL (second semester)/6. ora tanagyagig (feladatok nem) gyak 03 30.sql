Listazza a Volkswagen, Toyota es Opel markaju autokat,
amelyeknek az elso vasarlasi ara 1m es 5m koze esik,
a szin ki van t?ltve. A lista legyen rendezve m?rka, azon bel?l t?pus
azon bel?l els? v?s?rl?si ?r szerint;

SELECT *
FROM szerelo.sz_auto a JOIN szerelo.sz_autotipus at
    ON a.tipus_azon = at.azon
WHERE szin IS NOT NULL
    AND marka IN ('Opel','Volkswagen','Toyota')
    AND elso_vasarlasi_ar >= 1000000
    AND elso_vasarlasi_ar <= 5000000
ORDER BY marka, megnevezes, elso_vasarlasi_ar;


Melyek azok a sz?nek, amelyekhez 5-n?l t?bb aut? tartozik?;

SELECT szin, count(*)
FROM szerelo.sz_auto
GROUP BY szin
HAVING COUNT(*) > 5;

Melyek azok az aut?k (rendszam), amelyekhez 3-n?l kevesebb fel?rt?kel?s tartozik?;

SELECT rendszam, count(*)
FROM szerelo.sz_autofelertekeles af JOIN szerelo.sz_auto a
    ON af.auto_azon = a.azon
GROUP BY rendszam
HAVING COUNT(*) > 3;


Melyek azok az aut?k, amelyeket nem szereltek?;

SELECT *
FROM szerelo.sz_auto a LEFT JOIN szerelo.sz_szereles sz
    ON a.azon = sz.auto_azon
WHERE auto_azon IS NULL;

Melyek azok az aut?k, amelyeknek az els? v?s?rl?si ?ra t?bb, mint
a piros aut?k ?tlagos els? v?s?rl?si ?ra?;

SELECT *
FROM szerelo.sz_auto
WHERE elso_vasarlasi_ar >
(
SELECT avg(elso_vasarlasi_ar)
FROM szerelo.sz_auto
WHERE szin = 'piros'
);


Melyik aut?nak van a legnagyobb els? v?s?rl?si ?ra?;

SELECT *
FROM szerelo.sz_auto
ORDER BY elso_vasarlasi_ar DESC NULLS LAST
FETCH FIRST ROW ONLY;

A legfiatalabb szerel? mely szerel?m?helyben(azon, nev) dolgozik?;

SELECT sz.nev,szm.nev
FROM szerelo.sz_szerelo sz JOIN szerelo.sz_dolgozik d
    ON sz.azon = d.szerelo_azon
        JOIN szerelo.sz_szerelomuhely szm
            ON d.muhely_azon = szm.azon
ORDER BY szul_dat DESC
FETCH FIRST ROW ONLY;

-- listazzuk ki a szerzok teljes nevet az azonositojukkal, valamint az olvasok teljes nevet az olvasojegyszamukkal;
-- rendezzuk az eredmenyt a keresztnevek, azon belul a vezeteknevek szerint abecerendbe

SELECT vezeteknev, keresztnev, to_char(szerzo_azon)
FROM KONYVTAR.szerzo
UNION
SELECT vezeteknev, keresztnev, olvasojegyszam
FROM KONYVTAR.tag
ORDER BY keresztnev, vezeteknev;

-- listazzuk ki az osszes keresztnevet, 
-- akar szerzohoz, akar olvasohoz tartozik
-- (kiszuri a megegyezeseket)

SELECT keresztnev
FROM KONYVTAR.szerzo
UNION
SELECT keresztnev
FROM KONYVTAR.tag;

-- listazzuk ki az osszes keresztnevet, 
-- akar szerzohoz, akar olvasohoz tartozik;
-- minden nevet annyiszor szeretnenk latni, 
-- ahanyszor elofordul. Rendezzuk az eredmenyt


SELECT keresztnev
FROM KONYVTAR.szerzo
UNION ALL
SELECT keresztnev
FROM KONYVTAR.tag
ORDER BY 1;

-- listazzuk ki az egyes besorolasokat es mellettuk azt, 
-- hogy az adott besorolasu olvasok osszesen hany kolcsonzest realizaltak;
-- azokat a besorolasokat is latni szeretnenk (0 darabszammal), 
-- amelyekhez tartozo olvasok soha nem kolcsonoztek semmit;
-- rendezzuk az eredmenyt a kolcsonzesek szama szerint csokkeno sorrendbe

SELECT besorolas, COUNT(kolcsonzesi_datum)
FROM KONYVTAR.tag t LEFT JOIN KONYVTAR.kolcsonzes k
    ON t.olvasojegyszam = k.tag_azon
GROUP BY besorolas
ORDER BY 2 DESC;

