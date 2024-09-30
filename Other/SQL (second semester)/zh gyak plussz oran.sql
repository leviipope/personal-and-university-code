-- Listazza ki a legalabb 30 eves szerelok nevet, 
-- eletkorat (evben merve, kerekitve) es telefonszamat! 
-- A lista legyen eletkor szerint csokkenoen rendezve
 
 SELECT nev, round(months_between(sysdate, szul_dat)/12) eletkor, telefon
 FROM SZERELO.sz_szerelo
 WHERE round(months_between(sysdate, szul_dat)/12) >= 30
 ORDER BY 2 DESC;
 
 -- Listazza ki az automarkakat a nevuk alapjan csokkeno sorrendbe
 
 SELECT nev
 FROM SZERELO.sz_automarka
 ORDER BY nev DESC;
 
 -- Kerdezze le az ora025 rendszamu auto szinet es az elso vasarlasi kori arat
 
 SELECT szin, elso_vasarlasi_ar
 FROM SZERELO.sz_auto
 WHERE rendszam = 'ORA025';
 
 -- Listazza ki azoknak a debreceni autotulajdonoskank az azonositojat es nevet
 -- akiknek a neve legfejebb 10 karajkter hosszusagu! 
 -- A debreceni tulajdonosok cime ugy kezdodik hogy 'debrecen'.
 -- a lista nev szerint legyen novekvoen rendezve
 
 SELECT azon, nev
 FROM SZERELO.sz_tulajdonos
 WHERE length(nev) <= 10
    AND cim LIKE 'Debrecen%'
ORDER BY nev ASC;

-- Listazza ki azoknak az autokat az azonositojat es szerelesi idejet
-- napokban merve, amelyeket a 102-es azonositoval rendelkezo muhelyben
-- legfejebb harom napig szereltek! Listazza azoknak a sorokat is amelyeknel
-- a szereles meg nem ert veget, de a szereles kezdetehez kepest harom
-- napon belul meg befejezodhet!
-- Rendezze a listat a szerelesi ido szerint csokkeno sorrendbe

SELECT muhely_azon, auto_azon, nvl(szereles_vege,sysdate) - szereles_kezdete
FROM SZERELO.sz_szereles
WHERE muhely_azon = 102
    AND nvl(szereles_vege,sysdate) - szereles_kezdete <= 3
ORDER BY 3 DESC;

-- Mikor vasarltok az elso autoikat az egyes tulajdonosok
-- A listaban a tulajdonosokat azonitojukkal adja meg!
-- Rendezze az eredemnyt az elso vasarlasok szerint csokkeno sorrendbe!

SELECT tulaj_azon, to_char(MIN(vasarlas_ideje), 'DS TS') elso_vasarlas
FROM SZERELO.sz_auto_tulajdonosa
GROUP BY tulaj_azon
ORDER BY elso_vasarlas DESC;

-- Mekkora ertekben vegeztek osszesen szerelesi munkat az egyes autokon
-- A listaban  az autokat az azonositojukkal adjuk meg
-- Rendezze az eredemnyt az osszes munkavegzes koltsge szerint novekvo sorrendbe

SELECT auto_azon, nvl(SUM(munkavegzes_ara),0)
FROM SZERELO.sz_szereles
GROUP BY auto_azon
ORDER BY 2 ASC;

-- Mely autokat ertekeltek fel 3-nal tobbszor?
-- Az autokat azonositojukkal adjuk meg

SELECT auto_azon, COUNT(datum)
FROM SZERELO.sz_autofelertekeles
GROUP BY auto_azon
HAVING COUNT(datum) > 3;

-- irja ki a 178-as azonositoju auto elso tulajdosanak a nevet

SELECT nev
FROM SZERELO.sz_auto_tulajdonosa at JOIN SZERELO.sz_tulajdonos t
    ON at.tulaj_azon = t.azon
WHERE auto_azon = 178 AND at.vasarlas_ideje =
                            (SELECT MIN(vasarlas_ideje)
                             FROM SZERELO.sz_auto_tulajdonosa
                             WHERE auto_azon = 178
                            );
                            
-- Mennyi volt az 1998-ban ertekesitett 'Suzuki' markaju autok 
-- elso vasarlasi ara tipusonkent? Az eredmenyben a
-- tipusok megnevezeset es az atlagarakat tuntesse fel!

SELECT at.azon, AVG(elso_vasarlasi_ar)
FROM SZERELO.sz_autotipus at JOIN SZERELO.sz_auto a
    ON at.azon = a.tipus_azon
WHERE marka = 'Suzuki'
    AND extract(year from elso_vasarlas_idopontja) = 2005
GROUP BY at.azon;

-- Mely autokat javitottak a 'fektelnul bt.' nevu szervizben
-- az autokat a rendszamukkal adja meg mindegyik egyszer szerepeljen,abc rendben

SELECT DISTINCT rendszam
FROM SZERELO.sz_auto a JOIN SZERELO.sz_szereles sz
    ON a.azon = sz.auto_azon
    JOIN SZERELO.sz_szerelomuhely szm
        ON sz.muhely_azon = szm.azon
WHERE szm.nev = 'Féktelenül Bt.'
ORDER BY rendszam;

-- LIstazza ki azon autok rendszamait, amelyek elso vasarlasi ara kisebb
-- mint a kek autok elso vasarlasasi arainak az atlaga

SELECT rendszam
FROM SZERELO.sz_auto
WHERE elso_vasarlasi_ar < (SELECT avg(elso_vasarlasi_ar)
                           FROM SZERELO.sz_auto
                           WHERE szin = 'kék'
                          );
                        
-- 

SELECT azon
FROM SZERELO.sz_autotipus
WHERE marka IN (

SELECT marka
FROM szerelo.sz_autotipus
WHERE leiras LIKE '%benzin%'
GROUP BY marka
HAVING COUNT(*) > 1
);
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 