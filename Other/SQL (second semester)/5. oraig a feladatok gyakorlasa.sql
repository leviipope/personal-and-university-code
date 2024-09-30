SELECT *
    FROM KONYVTAR.konyv k JOIN KONYVTAR.konyvtari_konyv kk
        ON k.konyv_azon = kk.konyv_azon
    WHERE cim LIKE 'N%';

SELECT *
    FROM KONYVTAR.konyv JOIN KONYVTAR.konyvtari_konyv
        USING (konyv_azon);
    
SELECT *
    FROM KONYVTAR.konyv NATURAL JOIN KONYVTAR.konyvtari_konyv;
    
-- irassuk ki a "Tíz kicsi néger" cimu konyv peldanyainak leltari szamat es erteket

SELECT kk.leltari_szam, kk.ertek    
    FROM KONYVTAR.konyv k JOIN KONYVTAR.konyvtari_konyv kk
        USING (konyv_azon)
    WHERE cim like 'Tíz kicsi néger';
    
-- Stephen King mennyi honorariumban reszesult az egyes konyveiert
SELECT konyv_azon, honorarium
    FROM KONYVTAR.szerzo sz JOIN KONYVTAR.konyvszerzo ksz
        USING (szerzo_azon)
    WHERE sz.keresztnev = 'Stephen' AND vezeteknev = 'King';
    
-- Stephen King mennyi honorariumban reszesult az egyes konyveiert 
-- (a konyveket a cimukkel adjuk meg)?
SELECT vezeteknev, keresztnev, konyv_azon,cim ,honorarium
    FROM KONYVTAR.szerzo sz JOIN KONYVTAR.konyvszerzo ksz
        USING (szerzo_azon)
    JOIN KONYVTAR.konyv k 
        USING (konyv_azon)
    WHERE vezeteknev = 'King' AND keresztnev = 'Stephen';

-- ki irta a "Tíz kicsi néger" cimu konyvet?
SELECT vezeteknev || ', ' || keresztnev nev
    FROM KONYVTAR.szerzo NATURAL JOIN KONYVTAR.konyvszerzo
        NATURAL JOIN KONYVTAR.konyv
    WHERE cim = 'Tíz kicsi néger';
    
-- adjuk meg azon diakok vezeteknevet es keresztnevet, 
-- akiknel jelenleg is van kint konyv (nincs megadva a visszahozasi datum), 
-- es adjuk meg a naluk levo konyvek cimet es a peldányok leltari szamat is
SELECT vezeteknev, keresztnev, ko.cim, leltari_szam
    FROM KONYVTAR.tag t JOIN KONYVTAR.kolcsonzes k
        ON t.olvasojegyszam=k.tag_azon
    JOIN KONYVTAR.konyvtari_konyv kk
        USING (leltari_szam)
    JOIN KONYVTAR.konyv ko
        USING (konyv_azon)
    WHERE visszahozasi_datum IS NULL;

SELECT cim, kiado, ar, kk.*
    FROM KONYVTAR.konyv k JOIN KONYVTAR.konyvtari_konyv kk
        ON k.konyv_azon = kk.konyv_azon
    WHERE cim LIKE 'D%';

-- melyek a D betus cimu konyvek?
SELECT cim, kiado, ar
    FROM KONYVTAR.konyv
    WHERE cim LIKE 'D%';
        
SELECT cim, kiado, ar
    FROM KONYVTAR.konyv
    WHERE konyv_azon NOT IN
        (SELECT konyv_azon
            FROM KONYVTAR.konyvtari_konyv);

SELECT cim, kiado, ar, leltari_szam, konyv_azon, ertek
    FROM KONYVTAR.konyv k LEFT JOIN KONYVTAR.konyvtari_konyv kk
        USING (konyv_azon)
    WHERE cim LIKE 'D%';
    
-- listazzuk ki a nyugdijas olvasoinkat az osszes adatukkal, 
-- valamint a kolcsonzeseiket is az osszes adatukkal;
-- azokat az olvasokat is listazzuk, akik sosem kolcsonoztek semmit
SELECT *
    FROM KONYVTAR.tag t LEFT JOIN KONYVTAR.kolcsonzes k
        ON t.olvasojegyszam = k.tag_azon
    WHERE besorolas = 'nyugdíjas';
    
-- listazzuk ki az atlagosnal idosebb szerzok nevet, 
-- valamint hogy hany konyvet irtak;
-- azok a szerzok is szerepeljenek a listaban, 
-- akik nem irtak egyetlen konyvet sem (ertelemszeruen 0 ertekkel)
SELECT vezeteknev, keresztnev, COUNT(konyv_azon) Konyvek
    FROM KONYVTAR.szerzo sz LEFT JOIN KONYVTAR.konyvszerzo ksz
        USING (szerzo_azon)
    WHERE sysdate-szuletesi_datum >
        (SELECT AVG(sysdate - szuletesi_datum) FROM konyvtar.szerzo)
    GROUP BY szerzo_azon, vezeteknev, keresztnev;
    
-- listazzuk ki a krimi temaju konyveink cimet, azok osszes peldanyanak leltari szamaval es ertekevel egyutt;
-- azokat a konyveket is listazzuk, amelyeknek egy peldanya sincs a konyvtarunkban;
-- ezen konyvek eseten a leltari szam helyen a "nincs ilyen" sztring, az ertek helyen
SELECT cim, nvl(leltari_szam, 'nincs ilyen'), nvl(ertek,0)
    FROM KONYVTAR.konyv k LEFT JOIN KONYVTAR.konyvtari_konyv kk
        USING (konyv_azon)
    WHERE tema = 'krimi';
    
--List?zza a Volkswagen, Toyota ?s Opel m?rk?j? aut?kat,
--amelyeknek az els? v?s?rl?si ?ra 1m ?s 5m k?z? esik,
--a szin ki van t?ltve. A lista legyen rendezve m?rka, azon bel?l t?pus
--azon bel?l els? v?s?rl?si ?r szerint;

SELECT *
    FROM SZERELO.sz_auto au JOIN SZERELO.sz_autotipus ato
        ON  au.tipus_azon = ato.azon
    WHERE szin IS NOT NULL
        AND elso_vasarlasi_ar BETWEEN 1000000 AND 5000000
                AND marka IN ('Toyota','Opel','Volkswagen')
    ORDER BY marka, megnevezes, elso_vasarlasi_ar;
    
--Melyek azok a sz?nek, amelyekhez 5-n?l t?bb aut? tartozik?;

SELECT szin, count(*)
    FROM SZERELO.sz_auto
    GROUP BY szin
    HAVING COUNT(*)>5;

--Melyek azok az aut?k (rendszam), amelyekhez 3-n?l t?bb fel?rt?kel?s tartozik?

SELECT azon, rendszam
    FROM SZERELO.sz_auto au JOIN SZERELO.sz_autofelertekeles af
        ON au.azon = af.auto_azon
    GROUP BY azon, rendszam
    HAVING COUNT(*)>3;
    

    
SELECT *
    FROM SZERELO.sz_autofelertekeles;

SELECT *
    FROM SZERELO.sz_auto;
    
SELECT *
    FROM SZERELO.sz_autotipus;





