/*
    FELADAT TEMATIKA:

    1. egyszeru SELECT, WHERE, ORDER BY
    2. egyszeru SELECT, IS NULL, LIKE, ORDER BY
    3. datumos SELECT-ek
    4. GROUP BY
    5. GROUP BY, HAVING
    6. JOIN 2 tablara
    7. JOIN 2 tablara, GROUP BY, HAVING
    8. JOIN 3 tablara
    9. beagyazott SELECT aggregacios fuggvenyekkel
    10. beagyazott SELECT aggregacios fuggvenyekkel és IN-nel

*/

-- 1. egyszeru SELECT, WHERE, ORDER BY

-- Keressuk azokat a konyveket, amelyek nem krimi es sci-fi temajuak
-- vagy aruk 10000-nel tobb. 
-- A listat rendezzuk ar szerint novekvoen, azon belul cím csokkenoen.
SELECT konyv_azon,cim,ar,tema
FROM KONYVTAR.konyv
    WHERE tema NOT IN ('krimi','sci-fi')
        OR ar > 10000
    ORDER BY ar, cim DESC;


-- Keressuk azoknak a konyveknek a címet es arat, amelyeknek az ara nem ezer es haromezer kozott van. 
-- A listat rendezzuk ar szerint csokkenoen.
SELECT *
FROM KONYVTAR.konyv
    WHERE ar NOT BETWEEN 1000 AND 3000
ORDER BY ar DESC;


-- 2. egyszeru SELECT, IS NULL, LIKE, ORDER BY

-- Listazzuk ki a konyvek cimet és temajat, 
-- ugy hogy ha null ertek lenne a tema, akkor helyette 3 db '*'-ot irjunk.
-- A listat rendezzuk a tema alapjan!
SELECT cim, nvl(tema,'***')
FROM KONYVTAR.konyv
ORDER BY tema;


-- Keressuk azokat a konyveket, amelyeknek nincs megadva a kiadojuk.
-- A listat rendezzuk kiado alapjan, a null ertekek keruljenek utoljara.
SELECT *
FROM KONYVTAR.konyv
ORDER BY kiado NULLS LAST;

-- Listázzuk ki azon tagokat, melyen teljes nevében szerepel legalább két 'a' betû 
-- (mindegy hogy kicsi vagy nagy). Az eredményt rendezzük olvasójegyszám alapján.
SELECT vezeteknev || ' ' || keresztnev, olvasojegyszam
FROM KONYVTAR.tag
    WHERE lower(vezeteknev || ' ' || keresztnev) LIKE '%a%a%'
ORDER BY olvasojegyszam;

-- Listázzuk ki a pontosan két 'a' betût tartalmazó tagjaink teljes nevét és olvasójegyszámát.
SELECT vezeteknev || ' ' || keresztnev, olvasojegyszam
FROM KONYVTAR.tag
    WHERE lower(vezeteknev || ' ' || keresztnev) LIKE '%a%a%'
        AND lower(vezeteknev || ' ' || keresztnev)NOT LIKE '%a%a%a%'
ORDER BY olvasojegyszam;

-- Melyek azok a tagok, akiknek a lakcímében szerepel az 'út' szó?
SELECT  vezeteknev || ' ' || keresztnev, cim 
FROM KONYVTAR.tag
    WHERE lower(cim) LIKE '%út%';


-- 3. datumos SELECT-ek

-- Listázzuk ki az 1980.03.02 elõtt született férfi tagok nevét és születési dátumát.
-- A szuletesi datum legyen yyyy/mm/dd formatumban.

SELECT vezeteknev || ' ' || keresztnev, to_char(szuletesi_datum,'yyyy/mm/dd')
FROM KONYVTAR.tag
    WHERE szuletesi_datum < to_date('1980.03.02', 'yyyy.mm.dd')
    AND nem = 'f';

-- Listázzuk ki a 2000-ben vagy az elõtt született tagok nevét és születési évét,
-- csak azoknal a tagoknal ahol letezik a datum!
-- A lista legyen a szuletesi datum szerint csokkenoen rendezve.

SELECT *
FROM KONYVTAR.tag
    WHERE szuletesi_datum IS NOT NULL
    AND szuletesi_datum < to_date('2000.01.01', 'yyyy.mm.dd')
ORDER BY szuletesi_datum DESC;

-- Listázzuk ki a 30 évnél fiatalabb tagjaink nevét, születési dátumát és életkorát, utóbbi kerekítve.

SELECT vezeteknev || ' ' || keresztnev, szuletesi_datum, round(months_between(sysdate,szuletesi_datum)/12) "életkor"
FROM KONYVTAR.tag
WHERE months_between(sysdate,szuletesi_datum) < 30*12;


-- 4. GROUP BY + 5. GROUP BY, HAVING

-- Temankent mennyi az atlagos oldalszam?
SELECT tema, avg(oldalszam)
FROM KONYVTAR.konyv
GROUP BY tema;

-- Melyik szerzo (csak szerzo_azon) osszhonorariuma nagyobb, mint 2000000?

SELECT szerzo_azon, sum(honorarium)
FROM KONYVTAR.konyvszerzo
GROUP BY szerzo_azon
HAVING sum(honorarium) > 2000000;

-- Melyek azok a temak, amelyekben 3-nal tobb olyan konyvet adtak ki, 
-- amelyeknek az ara 1000 es 3000 kozott van?

SELECT tema
FROM konyvtar.konyv
    WHERE ar BETWEEN 1000 AND 3000
GROUP BY tema HAVING COUNT(konyv_azon)>3;

-- Melyik az a születési év és hónap, amelyikben több, mint 10 tag született?
-- Nem adott eredményt/ hibás feladat

-- Melyik az a születési év amelyikben több, mint 2 tag született?
SELECT to_char(szuletesi_datum,'YYYY')
FROM KONYVTAR.tag
GROUP BY to_char(szuletesi_datum,'YYYY')
    HAVING COUNT(olvasojegyszam)>2;
    

-- 6. JOIN 2 tablara

-- Listazzuk a horror temaju konyvekert kapott honorariumokat.
SELECT *
FROM KONYVTAR.konyv k JOIN KONYVTAR.konyvszerzo ksz
    ON k.konyv_azon = ksz.Konyv_azon
WHERE tema LIKE 'horror';

-- Listazzuk a PARK KONYVKIADO KFT. es a EUROPA KONYVKIADO KFT. kiadoju konyvek osszes konyvenek azonositojat, 
-- es ha van hozza peldany, akkor annak a leltari szamat.

SELECT k.konyv_azon,kiado,cim,leltari_szam
FROM KONYVTAR.konyv k LEFT JOIN KONYVTAR.konyvtari_konyv kk
    ON k.konyv_azon = kk.konyv_azon
    WHERE kiado IN ('EURÓPA KÖNYVKIADÓ KFT.','PARK KÖNYVKIADÓ KFT.');
    

-- 7. JOIN 2 tablara, GROUP BY, HAVING

-- Listazzuk ki azokat a kiadokat, amelyek 1000000 kevesebb osszhonorariumot osztottak ki. A lista legyen rendezett.

SELECT kiado, nvl(SUM(honorarium),0)
FROM KONYVTAR.konyv k JOIN KONYVTAR.konyvszerzo ksz
    ON k.konyv_azon = ksz.konyv_azon
GROUP BY kiado
HAVING SUM(nvl(honorarium,0))<1000000
ORDER BY kiado;

-- Mely szerzoknek nagyobb az osszhonorariuma 1 millional?

SELECT sz.szerzo_azon, SUM(honorarium)
FROM KONYVTAR.szerzo sz JOIN KONYVTAR.konyvszerzo ksz
    ON sz.szerzo_azon = ksz.szerzo_azon
GROUP BY sz.szerzo_azon
HAVING SUM(nvl(honorarium,0)) > 1000000;

select sz.szerzo_azon, sz.vezeteknev, sz.keresztnev, sum(honorarium)
from konyvtar.szerzo sz inner join konyvtar.konyvszerzo ksz
on sz.szerzo_azon=ksz.szerzo_azon
group by sz.szerzo_azon, sz.vezeteknev, sz.keresztnev
having sum(honorarium)>1000000;


-- 8. JOIN 3 tablara

-- Ki irta a Napoleon cimu konyvet?

SELECT cim, sz.vezeteknev, sz.keresztnev
FROM KONYVTAR.konyv k JOIN KONYVTAR.konyvszerzo ksz
    ON k.konyv_azon = ksz.konyv_azon
    JOIN KONYVTAR.szerzo sz
        ON ksz.szerzo_azon = sz.szerzo_azon
WHERE k.cim LIKE 'Napóleon';

-- 9. beagyazott SELECT aggregacios fuggvenyekkel

--  A krimi temaju konyvekbol melyik a legdragabb?

--SELECT *
--FROM KONYVTAR.konyv k
--    WHERE tema LIKE 'krimi'
--ORDER BY ar DESC
--FETCH FIRST ROW WITH TIES;

SELECT *
FROM KONYVTAR.konyv
WHERE ar LIKE (SELECT MAX(ar)
             FROM KONYVTAR.konyv
             WHERE tema LIKE 'krimi');

-- Ki a legidosebb szerzo?

SELECT *
FROM KONYVTAR.szerzo
WHERE szuletesi_datum LIKE (
                            SELECT MIN(szuletesi_datum)
                            FROM KONYVTAR.szerzo);


-- Listazzuk ki az atlagnal idosebb szerzok nevet es eletkorat!

SELECT vezeteknev, keresztnev, months_between(sysdate,szuletesi_datum)/12 eletkor
FROM KONYVTAR.szerzo
WHERE months_between(sysdate, szuletesi_datum) > (SELECT AVG(months_between(sysdate,szuletesi_datum))
                                                   FROM KONYVTAR.szerzo);

-- 10. beagyazott SELECT aggregacios fuggvenyekkel és IN-nel

-- Mi a legdrágább értékû könyv címe?

SELECT cim
FROM KONYVTAR.konyv
WHERE konyv_azon IN (SELECT konyv_azon
                     FROM KONYVTAR.konyvtari_konyv
                     WHERE ertek = (SELECT MAX(ertek)
                                    FROM KONYVTAR.konyvtari_konyv));



