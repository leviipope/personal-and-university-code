/*
Az SQL (Structured Query Language) magyarul: strukturalt lekerdezo nyelv.
Deklarativ programozasi nyelv imperativ elemekkel.

Relacios adatmodell: Edgar Frank Codd tervezte. Alapelve: az adatokat tablazatokban (relaciokban)
kepzeli el. A tablazatnak vannak sorai, oszlopai, van egy fejlece. A fejlec a relacio semajat
(az oszlopok nevet, tipusat, megszoritasait), az oszlopok az attributumokat (tulajdonsagokat),
a sorok a rekordokat (egyedeket) jelkepezik.

Pelda:

HALLGATO:   <-- tabla (relacio) neve

| Neptun-kod | Nev         | Anyja neve | Atlag |   <-- fejlec
-------------+-------------+------------+--------
| ABC123     | Gipsz Jakab | Nagy Jolan | 5.0   |   <-- sor
| AAA111     | Remek Elek  | Jo Adel    | 1.0   |
     ^
     |
   oszlop

Haromfele fogalomrendszer:

Tablazatos | Codd-fele         | Bachman-fele
-----------+-------------------+------------------------
tabla      | relacio           | -
oszlop     | attributum        | tulajdonsagtipus
sor        | rekord            | egyed(-elofordulas)
cella      | (attributum)ertek | tulajdonsag-elofordulas
fejlec     | (relacio)sema     | egyedtipus

Az adatbazis ket reszbol all: adatszotar (katalogus, metaadatbazis) es fizikai adatbazis.
Az adatszotar a fejlecek (sorok nelkuli tablak) osszessege.
A fizikai adatbazis a sorok osszessege.

Tovabbi fogalmak:
- NULL ertek (megjeleneset a Tools->Preferences...->Database->Advanced menuben lehet atallitani)
- elsodleges kulcs (primary key)
- kulso (idegen) kulcs (foreign key)

SQL resznyelvei (alnyelvei):
- DML (Data Manipulation Language): a fizikai adatbazist manipulalo utasitasok
  (SELECT, INSERT, UPDATE, DELETE, MERGE)
- DDL (Data Definition Language): a metaadatbazist (adatszotarat) manipulalo utasitasok,
  azaz a semaobjektumok letrehozasa, modositasa es torlese (CREATE ..., ALTER ..., DROP ...)
- DCL (Data Control Language): az adatbazis mukodeset befolyasolo utasitasok,
  pl. jogosultsagkezeles (GRANT, REVOKE), tranzakciokezeles (COMMIT, ROLLBACK, SAVEPOINT)
- DQL (Data Query Language): csak a SELECT
*/


-- 0. Elso SELECT:)
SELECT * FROM dual;

SELECT to_char(sysdate) FROM dual;
SELECT to_char(sysdate, 'YYYY.MM.DD.') FROM dual;
SELECT to_char(sysdate, 'YYYY.MM.DD. HH24:MI:SS') FROM dual;

-- 1. Listazzuk ki a tagokat!
SELECT *
FROM konyvtar.tag;

-- 2. Listazzuk ki a tagok nevet!
SELECT vezeteknev, keresztnev
FROM konyvtar.tag;

/* 3. Listazzuk ki a tagok nevet! A listat rendezzuk keresztnev szerint csokkenoen, majd vezeteknev szerint novekvoen!
   + keresztnevek istmetlodes nelkul
*/
SELECT vezeteknev, keresztnev
FROM konyvtar.tag
ORDER BY keresztnev DESC, vezeteknev ASC;

-- 4. Listazzuk ki a tagok nevet egy oszlopban! A listat rendezzuk nev szerint!
SELECT vezeteknev ||' '|| keresztnev nev
FROM konyvtar.tag
ORDER BY nev;

-- 5. Listazzuk ki a konyveket. A lista legyen ar szerint rendezett, es a null ertekek elol szerepeljenek.
SELECT *
FROM konyvtar.konyv
ORDER BY ar NULLS FIRST;

-- 6. Listazzuk ki a konyveket. A lista legyen ar szerint csokkenoen rendezett, es a null ertekek a vegen szerepeljenek.
SELECT *
FROM konyvtar.konyv
ORDER BY ar DESC NULLS LAST;

-- 7. Listazzuk ki a noi tagokat! A listat rendezzuk nev szerint!
SELECT *
FROM konyvtar.tag
WHERE nem='n'
ORDER BY vezeteknev, keresztnev;

-- 8. Listazzuk ki Luc Erna nevu tag minden adatat!
SELECT *
FROM konyvtar.tag
WHERE vezeteknev='Luc' AND keresztnev='Erna';

-- 9. Listazzuk ki a diak besorolasu tagok minden adatat! A lista legyen nev szerint rendezett.
SELECT *
FROM konyvtar.tag
WHERE besorolas='diák'
ORDER BY vezeteknev, keresztnev;

-- 10. Listazzuk ki azokat a tagokat, akiknek a tagdíja tobb, mint 1000 es a besorolasa felnott!
SELECT *
FROM konyvtar.tag
WHERE tagdij>1000 AND besorolas='feln?tt';

-- 11. Listazzuk ki azokat a konyveket, amelyek krimi temajuak, es amelyeknek az ara tobb, mint 3000! A lista legyen cím szerint rendezett.
SELECT *
FROM konyvtar.konyv
WHERE tema='krimi' AND ar>3000
ORDER BY cim;

-- 12. Listazzuk ki azokat a konyveket, amelyek krimi temajuak, vagy amelyeknek az ara tobb, mint 3000! A lista legyen cím szerint rendezett.
SELECT *
FROM konyvtar.konyv
WHERE tema='krimi' OR ar>3000
ORDER BY cim;

-- 13. Írjunk megjegyzest!
/*tobbsoros
megjegyzes*/
--megjegyzes

-- 14. Listazzuk ki azokat a tagokat, akiknek a tagdíja tobb, mint 1000 vagy a besorolasa felnott!
SELECT *
FROM konyvtar.tag
WHERE tagdij>1000 OR besorolas='felnott';

-- 15. Listazzuk ki azokat a tagokat, akikre nem igaz, hogy a tagdíja tobb, mint 1000 vagy a besorolasa felnott!
SELECT *
FROM konyvtar.tag
WHERE NOT (tagdij>1000 OR besorolas='felnott');

-- 16. Keressuk azokat a tagokat, akiknek a besorolasa diak, nyugdíjas vagy gyerek.
SELECT *
FROM konyvtar.tag
WHERE besorolas='diák' OR besorolas='nyugdíjas'
OR besorolas='gyerek'
ORDER BY besorolas, vezeteknev, keresztnev;

SELECT *
FROM konyvtar.tag
WHERE besorolas IN ('diák','nyugdíjas','gyerek')
ORDER BY besorolas, vezeteknev, keresztnev;

-- 17. Keressuk azoknak a konyveknek a címet es arat, amelyeknek az ara 1000 es 3000 kozott van. A listat rendezzuk ar, azon belul cím szerint.
SELECT ar, cim
FROM konyvtar.konyv
WHERE ar>=1000 AND ar<=3000
ORDER BY ar, cim;

SELECT ar, cim
FROM konyvtar.konyv
WHERE ar BETWEEN 1000 AND 3000
ORDER BY ar, cim;

-- 18. Keressuk azoknak a konyveknek a címet es arat, amelyeknek az ara nem nagyobb vagy egyenlo, mint ezer. A listat rendezzuk ar, azon belul cím szerint.
SELECT ar, cim
FROM konyvtar.konyv
WHERE NOT (ar >=1000)
ORDER BY ar, cim;

-- 19. Keressuk azoknak a konyveknek a címet es arat, amelyeknek az ara nem ezer es haromezer kozott van. A listat rendezzuk ar, azon belul cím szerint.
SELECT ar, cim
FROM konyvtar.konyv
WHERE ar NOT BETWEEN 1000 AND 3000
ORDER BY ar, cim;

-- 20. Keressuk azokat a konyveket, amelyek nem krimi es sci-fi temajuak. A listat rendezzuk ar, azon belul cím szerint.
SELECT *
FROM konyvtar.konyv
WHERE tema NOT IN ('krimi','sci-fi')
ORDER BY ar, cim;

-- 21. Keressuk azokat a konyveket, amelyek sci-fi temajuak vagy olcsobbak 1000-nel es oldalszamuk tobb, mint 200 vagy a Gondolat kiado a kiadojuk.
SELECT *
FROM konyvtar.konyv
WHERE (tema='sci-fi' OR ar<1000)
AND (oldalszam>200 OR kiado='Gondolat');

-- 22. Keressuk azokat a konyveket, amelyeknek nincs megadva a kiadojuk.
SELECT *
FROM konyvtar.konyv
WHERE kiado IS null;

-- 23. Keressuk azokat a konyveket, amelyeknek meg van adva a kiadojuk.
SELECT *
FROM konyvtar.konyv
WHERE kiado IS NOT null;

-- 24. Keressuk azokat a konyveket, amelyeknek a címe a 'Re' sztringgel kezdodik.
SELECT *
FROM konyvtar.konyv
WHERE cim LIKE 'Re%'

-- 25. Keressuk azokat a konyveket, amelyeknek a címe nem a 'Re' sztringgel kezdodik.
SELECT *
FROM konyvtar.konyv
WHERE cim NOT LIKE 'Re%';

-- 26. Keressuk azokat a konyveket, amelyeknek a címenek a 2. karaktere 'a'.
SELECT *
FROM konyvtar.konyv
WHERE cim LIKE '_a%';

/* 27. Melyek azok a konyvek, amelyeknek az oldalankenti ara tobb, mint 20? Listazzuk a konyv címet, azonosítojat, oldalankenti arat. 
   + a lista legyen az oldalankenti ar szerint rendezett.
   + kerekites
*/
SELECT cim, konyv_azon, round(ar/oldalszam)
FROM konyvtar.konyv
WHERE ar/oldalszam>20
ORDER BY ar/oldalszam