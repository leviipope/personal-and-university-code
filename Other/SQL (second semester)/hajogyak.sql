-- Listazza ki a 7 es 14 tonna koze eso rakomannyal rendelkezo kontenerek 
-- teljes azonositojat (megrendelesazonosito es kontenerazonosito), valamint 
-- a rakomanysulyt is 2 tizedesjegyre kerekitve! 
-- Redezze az eredmenyt a pontos rakomanysuly szerint csokkeno sorrendbe!

SELECT megrendeles, kontener, ROUND(rakomanysuly,2)
FROM HAJO.s_hozzarendel
    WHERE rakomanysuly BETWEEN 7 AND 14
ORDER BY rakomanysuly DESC;

-- Listazza ki azoknak az ugyfeleknek a teljes nevet "vezeteknev, keresztnev" 
-- formaban, akikrol nem tudjuk, melyik telepulesen laknak,de azt igen, hogy a
-- keresztnevuk 5 karakterbol all! A lista legyen vezeteknev alapjan csokkeno!

SELECT vezeteknev || ' ' || keresztnev teljes_nev
FROM HAJO.s_ugyfel
    WHERE helyseg IS NULL
        AND keresztnev LIKE '_____'
ORDER BY vezeteknev DESC;

-- Listazza ki a 2021 februarjaban es aprilisaban leadott megrendelesek datumat
-- es idopontjat, az indulasi es erkezesi kikotok azonositojat, valamint a
-- fizetett osszeget, ez utobbi szerint csokkeno sorrendben!

SELECT to_char(megrendeles_datuma,'yyyy.mm.dd hh24:mi:ss'), indulasi_kikoto, erkezesi_kikoto, fizetett_osszeg
FROM HAJO.s_megrendeles
    WHERE EXTRACT(year from megrendeles_datuma) = 2021
        AND EXTRACT(month from megrendeles_datuma) = 02
            OR EXTRACT(month from megrendeles_datuma) = 04
ORDER BY 4 DESC;

-- Mekkora az egyes foldreszek terulete (a foldreszen talalhato orszagok
-- teruletenek az osszege)? Rendezze az eredmenyt a teruletek csokkeno
-- sorrendjebe! A "nem ismert foldresz" ne jelenjen meg a listaba!

SELECT foldresz, SUM(terulet)
FROM HAJO.s_orszag
WHERE foldresz IS NOT NULL
GROUP BY foldresz
ORDER BY 2 DESC;

-- Mely ugyfelek rendeltek osszesen legalabb 10 millio ertekben, es mekkora
-- ez az ertek? Az ugyfeleket az azon-val adja meg!

SELECT ugyfel, SUM(fizetett_osszeg)
FROM HAJO.s_megrendeles
GROUP BY ugyfel
HAVING SUM(fizetett_osszeg) >= 10000000;

-- listazzza ki azoknak a hajotipusoknak a nevet, amilyen tipusu hajokkal
-- rendelkezik a cegunk! Egy tipusnev csak egyszer szerepeljen az eredmenyben!

SELECT nev
FROM HAJO.s_hajo_tipus;

-- Adja meg, hogy az egyes honapokban (ev, honap) hany olyan megrendelest 
-- adtak le, amely mobil darukkal rendelkezo kikotobe iranyult (azaz
-- az erkezesi kikoto leirasaban szerepel a 'mobil daru' sztring)!
-- Rendezze az eredmenyt darabszam szerint csokkeno sorrendbe!

SELECT to_char(m.megrendeles_datuma,'yyyy.mm'), COUNT(*)
FROM HAJO.s_megrendeles m JOIN HAJO.s_kikoto k 
    ON m.erkezesi_kikoto = k.kikoto_id
WHERE leiras LIKE '%mobil daruk%'
GROUP BY to_char(m.megrendeles_datuma,'yyyy.mm')
ORDER BY 2 DESC;
    
-- Listazza ki novekvo sorrendbe az 'Asterix' nevu hajo altal az 'It_Cat' 
-- azonositoju kikotobe szallitott megrendelesek azonositoit, mindegyiket
-- csak egyszer

SELECT DISTINCT megrendeles
FROM HAJO.s_hajo h JOIN HAJO.s_ut u
    ON h.hajo_id = u.hajo
    JOIN HAJO.s_szallit sz
        ON u.ut_id = sz.ut
WHERE h.nev = 'Asterix'
    AND u.erkezesi_kikoto = 'It_Cat';

-- Irja ki az utoljara leadott megrendelesek(ek)nek az azonositojat,
-- datumat, es idejet, az indulasi es erkezesi kikotok azonjat valamint
-- az ugyfel teljes nevet

SELECT megrendeles_id, megrendeles_datuma, indulasi_kikoto, erkezesi_kikoto, vezeteknev || ' ' || keresztnev
FROM HAJO.s_megrendeles m JOIN HAJO.s_ugyfel u
    ON m.ugyfel = u.ugyfel_id
WHERE megrendeles_datuma IN (SELECT megrendeles_datuma
                             FROM HAJO.s_megrendeles
                             GROUP BY megrendeles_datuma
                             ORDER BY megrendeles_datuma DESC
                             FETCH FIRST ROW ONLY
                             );

-- Irja ki a legidosebb olaszorszagi ugyfel\ugyfelek teljes nevet es
-- szuletesi datumat


SELECT vezeteknev || ' ' || keresztnev, szul_dat
FROM HAJO.s_ugyfel u JOIN HAJO.s_helyseg h
    ON u.helyseg = h.helyseg_id
WHERE orszag = 'Olaszország'
ORDER BY szul_dat
FETCH FIRST ROW WITH TIES;

-- listazza ki a 15 tonnat meghalado rakomannyal rendelkezo kontenerek 
-- teljes azonositojat (megrendelesazonosito es kontenerazonosito), valamint
-- a rakomanysulyt is 2 tizedesjegyre kerekitve! Rendezze az eredmenyt a pontos
-- rakomanysuly szerint novekvo sorrendbe!

SELECT megrendeles, kontener, ROUND(rakomanysuly,2)
FROM HAJO.s_hozzarendel
WHERE rakomanysuly > 15
ORDER BY rakomanysuly;

-- Listazza ki a kis meretu mobil darukkal rendelkezo kikotok adatait!

SELECT *
FROM HAJO.s_kikoto k    
WHERE leiras LIKE '%kiköt?méret: kicsi%'
    AND leiras LIKE '%mobil daruk%';
    
-- Listazza ki azoknak az utaknak az adatait (a datumokat idoponttal egyutt)
-- amelyek nem egesz percben idulnak! Rendezze az eredmenyt az indulasi ido
-- szerint novekvo sorrendbe!

SELECT ut_id, to_char(indulasi_ido,'yyyy.mm.dd hh24:ss') ind, to_char(erkezesi_ido,'yyyy.mm.dd hh24:ss') erk, indulasi_kikoto, erkezesi_kikoto, hajo
FROM HAJO.s_ut
WHERE to_char(indulasi_ido, 'ss') != 0
ORDER BY indulasi_ido ASC;

-- Hany 500 tonnanal nagyobb maximalis sulyterhelesu hajo tartozik az egyes
-- hajotipusokhoz? A hajotipusokat az azonositojukkal adjuk meg!

SELECT hajo_tipus, COUNT(*)
FROM HAJO.s_hajo
WHERE max_sulyterheles > 500
GROUP BY hajo_tipus;

-- Mely honapokban (ev, honap) adtak le legalabb 6 megrendelest? A lista legyen 
-- idorendi sorrendben!

SELECT to_char(megrendeles_datuma, 'yyyy.mm'), COUNT(*)
FROM HAJO.s_megrendeles
GROUP BY to_char(megrendeles_datuma, 'yyyy.mm')
HAVING COUNT(*) >= 6
ORDER BY 1 ASC;

-- Listazza ki a sziriai ugyfelek teljes nevet es telefonszamat!

SELECT vezeteknev || ' ' || keresztnev, telefon
FROM HAJO.s_ugyfel u JOIN HAJO.s_helyseg h
    ON h.helyseg_id = u.helyseg
WHERE orszag = 'Szíria';

-- Mennyi az eggyes hajotipusokhoz tartozo hajok legkisebb netto sulya?
-- A hajotipusokat nevukkel adja meg! Csak azokat a hajotipusokat listazza,
-- amelyekhez vannak hajoink!

SELECT ht.nev, MIN(netto_suly)
FROM HAJO.s_hajo h JOIN HAJO.s_hajo_tipus ht
    ON h.hajo_tipus = ht.hajo_tipus_id
GROUP BY ht.nev;

-- Melyik azsiai telepuleseken talalhato kikoto? Az eredmenyben orszag es
-- helysegneveket adja meg, orszagnev, azon belul helysegnev szerint rendezve

SELECT h.orszag, helysegnev
FROM HAJO.s_kikoto k JOIN HAJO.s_helyseg h
    ON k.helyseg = h.helyseg_id
    JOIN HAJO.s_orszag o
        ON h.orszag = o.orszag
WHERE foldresz = 'Ázsia'
ORDER BY 1,2;

-- Melyik hajo(k) indult(ak) utra utoljara? Listazza ki a hajoknak a nevet
-- azonositojat, az indulasi es erkezesi kikotok azonjat valamint az indulas
-- datumat es idejet!

SELECT hajo_id, nev, u.indulasi_kikoto, u.erkezesi_kikoto, to_char(u.indulasi_ido, 'yyyy.mm.dd hh24:ss') indulasi_ido
FROM HAJO.s_ut u JOIN HAJO.s_hajo h
    ON u.hajo = h.hajo_id
ORDER BY indulasi_ido DESC
FETCH FIRST ROW WITH TIES;

-- Az 'It_Cat' azonositoju kikotobol indulo legkorabbi ut/utak melyik kikotobe 
-- tartottak? Adja meg az erkezesi kikotok azonjat, valamint a helysegenek es
-- orszaganak a nevet

SELECT kikoto_id, helysegnev, orszag
FROM HAJO.s_kikoto k JOIN HAJO.s_helyseg h
    ON k.helyseg = h.helyseg_id
WHERE kikoto_id IN (SELECT erkezesi_kikoto
                    FROM HAJO.s_ut
                    WHERE indulasi_kikoto = 'It_Cat'
                    ORDER BY indulasi_ido
                    FETCH FIRST ROW WITH TIES
                    );


