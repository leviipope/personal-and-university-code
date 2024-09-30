--select feladatok from buvesz :*
--1
--Listázza ki az ügyfelek azonosítóját, teljes nevét, valamint a megrendeléseik azonosítóját! Azok az ügyfelek is szerepeljenek az eredményben,
--akik soha nem adtak le megrendeléseket. A lista legyen vezetéknév, azon belül megrendelés azonosítója szerint rendezve
SELECT ugyfel_id, vezeteknev || ' ' || keresztnev, megrendeles_id
FROM HAJO.s_ugyfel u LEFT JOIN HAJO.s_megrendeles m
    ON  u.ugyfel_id = m.ugyfel
ORDER BY vezeteknev, megrendeles_id;

--2.
--Listázza ki a hajótípusok azonosítóját és nevét, valamint az adott típusú hajók azonosítóját és nevét! A hajótípusok nevét tartalmazó oszlop
--'típusnév', a hajók nevét tartalmazó oszlop pedig 'hajónév' legyen! Azok a hajótípusok is jelenjenek meg, amelyhez egyetlen hajó sem tartzoik.
--A lista legyen a hajótípus neve, azon belül a hajó neve alapján rendezve.
SELECT hajo_tipus_id,ht.nev típusnév, hajo_id, h.nev hajónév 
FROM HAJO.s_hajo_tipus ht LEFT JOIN HAJO.s_hajo h
    ON ht.hajo_tipus_id = h.hajo_tipus;


--5.
--Listázza ki Magyarországénál kisebb lakossággal rendelkez? országok nevét, lakosságát, valamint a f?városuk nevét. Azokat az országokat is
--listázza, amelyeknek nem ismerjük a f?városát. Ezen országok esetében a f?város helyén "nem ismert" sztring szerepeljen. Rendezze az országokat
--a lakosság szerint csökken? sorrendben.
SELECT o.orszag, o.lakossag, nvl(helysegnev,'nem ismert')
FROM HAJO.s_orszag o LEFT JOIN HAJO.s_helyseg h
    ON o.fovaros = h.helyseg_id
WHERE (o.lakossag<(SELECT lakossag
                 FROM HAJO.s_orszag
                 WHERE orszag ='Magyarország'))
ORDER BY o.lakossag DESC;
    

--6 
--Listázza ki azoknak az ügyfeleknek az azonosítóját és teljes nevét,
--akik adtak már fel olasz- országi kiköt?b?l induló szállításra vonatkozó megrendelést! 
--Egy ügyfél csak egyszer szere- peljen az eredményben!
SELECT ugyfel_id, (vezeteknev || ' ' || keresztnev) teljesnev
FROM HAJO.s_ugyfel u JOIN HAJO.s_megrendeles m
    ON u.ugyfel_id = m.ugyfel
WHERE m.indulasi_kikoto LIKE 'It_%'
GROUP BY ugyfel_id, vezeteknev, keresztnev;

--7
--Listázza ki azoknak a hajóknak az azonosítóját és nevét, amelyek egyetlen út célállomásaként sem kötöttek ki francia kiköt?kben
SELECT hajo_id, nev
FROM HAJO.s_hajo h JOIN HAJO.s_ut u
    ON h.hajo_id = u.hajo
WHERE hajo_id NOT IN (SELECT hajo_id
                        FROM HAJO.s_hajo h JOIN HAJO.s_ut u
                            ON h.hajo_id = u.hajo
                        WHERE erkezesi_kikoto LIKE 'Fra_%')
GROUP BY hajo_id, nev;


--8.
--Listázza ki azoknak a helységeknek az azonosítóját, országát és nevét, amelyeknek valamelyik kiköt?jéb?l
--indult már útra az SC Bella nev? hajó! Egy helység csak egyszer szerepeljen



--9.
--Listázza ki azokat a mmegrendeléseket (azonosító) amelyekért többet fizettek, mint a 2021. áprilisában leadott megrendelések
--Bármelyikéért. A fizetett összeget is tüntesse fel!



--11
--Listázza ki azoknak a hajóknak a nevét, a maximális súlyterhelését, valamint a tipusának a nevét, amely egyetlen utat sem teljesített.
--A hajó nevét megadó oszlop neve a 'hajónév' a tipusnevét a 'tipusnév'.

--12.
--Listázza ki azoknak az ügyfeleknek a teljes nevét és származási országát, akiknek nincs 1milliónál nagyobb érték? rendelése!
--Azok is szerepeljenek, akiknek nem ismerjük a származását. Rendezze az eredményt vezetéknév, azon belül keresztnév szerint


--13
--Listázza ki ábécérendben azoknak a kiköt?knek az azonosítóját, amelyekbe vagy teljesített egy utat az It_Cat azonosítójú kiköt?b?l, vagy célpontja egy, az It_Cat
--azonosítój? kiköt?j? megrendelésnek!


--14.
--Listázza ki ábécérendben azoknak a kiköt?knek az azonosítóját, melyekbe legalább egy hajó teljesített utat
--Az 'It_Cat' azonosítójú kiköt?b?l és célpontja legalább egy, az 'It_Cat' kiköt?b?l induló megrendelésnek. A kiköt? csak egyszer
--Szerepeljen a lekérdezésben.


--15. 
--Listázza ki ábécérendben azoknak a helységeknek az azonosítóját, országát és nevét, ahonnan származnak ügyfeleink, vagy ahol vannak kiköt?k!
--Egy helység csak egyszer szerepeljen az eredményben! A lista legyen országnév, azon belül helységnév szerint rendezett.


--16
--Listázza ki ábécérendben azoknak a kiköt?vel rendelkez? helységeknek az azonosítóját,
--országát és nevét, ahonnan legalább egy ügyfelünk is származik! 
--Egy helység csak egyszer szerepeljen az eredményben! 
--A lista legyen országnév, azon belül helységnév szerint rendezve!

--19.
--Listázza ki növekv? sorrendben azoknak a megrendeléseknek az azonosítóját, amelyekért legalább kétmilliót fizetett
--Egy Yiorgos keresztnev? ügyfél, és még nem történt meg a szállításuk

--20
--Listázza ki azoknak a helységeknek az azonosítóját, 
--országát és nevét, amelyek lakossága meghaladja az egymillió f?t, és azokét is, 
--ahonnan származik 50 évesnél id?sebb ügyfelünk! 
--Egy helység csak egyszer szerepeljen az eredményben! A lista legyen országnév, azon belül helységnév szerint rendezve!

--22.
--Melyik három ország kiköt?jéb?l induló szállításokra adták le a legtöbb megrendelést?
--Az országnevek mellett tüntesse fel az onnan induló megrendelések számát is

--25
--Listázza ki a tíz legtöbb igényelt konténert tartalmazó megrendelést leadó ügyfél teljes nevét, 
--a megrendelés azonosítóját és az igényelt konténerek számát!

--26
--Adja meg az SC Nina nev? hajóval megtett 3 leghosszabb ideig tartó út indulási és érkezési kiköt?jének az azonosítóját.


--27
--Adja meg a három legtöbb utat teljesít? hajó nevét! A hajók neve mellett tüntesse fel az általuk teljesített utak számát is


--28
-- Az 'It Cat' azonosítójú kiköt?b?l induló utak közül melyik négyen szállították a legkevesebb konténert?
--Csak azokat az utakat vegye figyelembe, amelyeken legalább egy konténert szállítottak!
--Az utakat az azonosítójukkal adja meg, és tüntesse fel a szállított konténerek számát is!!

--29
--Adja meg a négy legtöbb rendelést leadó teljes nevét és a megrendelések számát


--31.
--Hozzon létre egy s_szemelyzet nevu tablat, amelyben a hajókon dolgozó személyzet adatai találhatóak. Minden szerel?nek van azonosítója
--Pontosan 10 karakteres sztring. Ez az els?dleges kulcs is. Vezeték és keresztneve mindkett? 50-50 karakteres sztring. Születési dátuma, egy telefonszáma
--(20 jegy? egész szám). És hogy melyik hajó személyzetéhez tartozik (max 10 karakteres sztring), és ezt egy hivatkozással az s_hajó táblára hozzuk létre.
--A telefonszámot legyen kötelez? megadni. Minden megszorítást nevezzen el
CREATE TABLE s_szemlyzet(
    azon CHAR(10 CHAR),
    CONSTRAINT sz_pk PRIMARY KEY(azon),
    vezeteknev VARCHAR2(50 CHAR),
    keresztnev VARCHAR2(50 CHAR),
    szul_dat DATE,
    telefonszam NUMBER(20) NOT NULL,
    hajo VARCHAR2(10 CHAR),
    CONSTRAINT sz_fk FOREIGN KEY(hajo) REFERENCES HAJO.s_hajo(hajo_id)
);

--32
--Hozzon létre egy s_személyzet nev? táblát, amelyben a hajókon dolgozó személyzet adatai találhatóak!
create table s_szemelyzet(
--Minden szerel?nek van azonosítója, maximum öt jegy? egész szám, ez az els?dleges kulcs
    azon number(5),
--vezeték és keresztneve, mindkett? maximum negyven karakteres sztring
    vezeteknev varchar2(40),
    keresztnev varchar2(40),
    --születési dátuma
    szul_dat date,
    --e-mail címe (maximum 200 karakteres string)
    email_cim varchar2(200),
    --hogy melyik hajó személyzetéhez tartozik (maximum 10 karakteres sztring), hivatkozással az s_hajó táblára
    hajo_id varchar2(10),
    constraint pk_szemelyzet primary key(azon),
    constraint fk_szemelyzet foreign key(hajo_id) references s_hajo(hajo_id),
    constraint uq_szemelyzet unique(vezeteknev, keresztnev, szul_dat)
);

--33
--Hozzon létre egy 's_kikoto_email' nev? táblát, amelyben a kiköt?k e-mail címét tároljuk! Legyen benne egy kikoto_id nev? oszlop
--(maximum 10 karakteres string), amely hivatkozik az s_kikoto táblára.
--Valamint egy email cím, ami egy maximum 200 karakteres string!
--Egy kiköt?nek több email címe lehet, ezért a tábla els?dleges kulcsát a két oszlop együttesen alkossa!
--Minden megszorítást nevezzen el!
CREATE TABLE s_kikoto_email(
    kikoto_id_nev VARCHAR2(10 CHAR),
    email VARCHAR2(200 CHAR),
    CONSTRAINT pk_kikoto_email PRIMARY KEY (kikoto_id_nev,email),
    CONSTRAINT fk_kikoto_email FOREIGN KEY(kikoto_id_nev) REFERENCES s_kikoto(kikoto_id)
);

--35.
--Hozzon létre egy s_hajo_javitas táblát, ami a hajók javítási adatait tartalmazza! Legyen benne a javított hajó azonosítója, amely az s_hajó táblára hivatkozik, legfeljebb
--10 karakter hosszú sztring és ne legyen null. Javítás kezdete és vége_ dárumok. Javítás ára: egy legfeljebb 10 jegy? valós szám, két tizedesjeggyel, valamint a hiba
--leírása, 200 karakteres sztring (legfeljebb).
--A tábla els?dleges kulcsa és a javítás kezd?dátuma els?dlegesen alkossa. További megkötés, hogy a javítás vége csak a javítás kezdete
--nél kés?bbi dátum lehet.


--43
--Törölje az s_hajo és az s_hajo tipus táblákat! Vegye figyelembe az egyes táblákra hivatkozó küls? kulcsokat.
DROP TABLE s_hajo CASCADE CONSTRAINTS;
DROP TABLE s_hajo_tipus CASCADE CONSTRAINTS;
--42
-- A helységek lakossági adata nem fontos számunkra.
--Törölje az 's_helyseg' tábla 'lakossag' oszlopát! 
ALTER TABLE s_helyseg
DROP COLUMN lakossag;

--44
--Törölje az 's_kikoto_telefon' tábla els?dleges kulcs megszorítását!
ALTER TABLE s_kikoto_telefon
DROP CONSTRAINT skt_pk;

--49.
--az s_kiköt? telefon táblát egy email nev?, amx 200 karakter hosszú sztringel, melyben alapértelmezetten a 'nem ismert' sztring legyen
CREATE TABLE s_kikoto(
    email VARCHAR2(200 CHAR) DEFAULT('nem ismert')
);

--50.
--Módosítsa az s_ugyfel tábla email oszlopának maximális hosszát 50 karakterre, az utca_hsz oszlop hosszát pedig 100 karakterre!
ALTER TABLE s_ugyfel
MODIFY COLUMN email VARCHAR2(50 CHAR)
MODIFY COLUMN utca_hsz VARCHAR2(100 CHAR);

--53
--Szúrja be a hajó sémából a saját sémájának s_ugyfel táblájába az olaszországi ügyfeleket!
INSERT INTO s_ugyfel (ugyfel_id, vezetekenev, keresztnev, telefon, email,szul_dat,helyseg,utca_hsz)
SELECT s_ugyfel (ugyfel_id, vezetekenev, keresztnev, telefon, email,szul_dat,helyseg,utca_hsz
FROM HAJO.s_ugyfel;

--54
--Szúrja be a hajó sémából a saját sémájának s_hajó táblájába a small feeder tipusú hajók közül azokat,
--amelyeknek nettó súlya legalább 250 tonna
INSERT INTO s_hajo (hajo_id, nev, netto_suly, max_kontener_dbszam, max_sulyterheles, hajo_tipus)
SELECT hajo_id, nev, netto_suly, max_kontener_dbszam, max_sulyterheles, hajo_tipus
FROM HAJO.s_hajo
WHERE netto_suly>=250;

--55.
--Szúrja be a 'hajó' sémából a saját sémájának s_hajo táblájába azokat a 'Small Feeder"' típusú hjaókat, amelyek legfeljebb 10 konténert
--tudnak szállítani egyszerre;


--57
--Törölje a szárazdokkal rendelkez? olaszországi és ibériai kiköt?ket! Azok a kiköt?k rendelkeznek szárazdokkal, amelyeknek a leírásában
--szerepel a szárazdokk szó.
DELETE FROM HAJO.s_kikoto
WHERE leiras LIKE 'szárazdokk'
    AND kikoto_id LIKE 'It_%' OR 'Liby_%';
    

--61
--Módosítsa a nagy terminálterülettel rendelkez? kiköt?k leírását úgy, 
--hogy az az elején tar- talmazza a kiköt? helységét is, 
--amelyet egy vessz?vel és egy sz?közzel válasszon el a leírás jelenlegi tartalmától! 
--A nagy terminálterülettel rendelkez? kiköt?k leírásában szerepel a 'terminálterület: nagy, sztring. 
--(Figyeljen a vessz?re, a nagyon nagy" terület? kiköt?ket nem szeretnénk módosítani!) 
UPDATE HAJO.s_kikoto
SET leiras = helyseg||', '||leiras
WHERE leiras LIKE 'terminálterület: nagy,';


--62
--Alakítsa csuba nagybet?ssé azon ügyfelek vezetéknevét, akik eddig a legtöbbet fizették összesen a megrendeléseikért
UPDATE HAJO.s_ugyfel
SET vezeteknev = UPPER(vezeteknev)
WHERE(ugyfel_id IN (SELECT ugyfel
                    FROM HAJO.s_megrendeles
                    ORDER BY fizetett_osszeg desc
                    FETCH FIRST 5 ROWS ONLY)
);


--67.
--A francia kereskedelmi jogszabályoknak nemrég bevezetett változások jelent?s költségnövekedést okoztak a cégünk számára a francia 
--megrendelések leszállítását illet?en. Növelje meg 15%-al a franciaországból származó ügyfeleink utolsó megrendeléseiért fizetett összeget

--68
--A népességi adataink elavultak. 
--A frissítésük egyik lépéseként növelje meg 5%-kal az ázsiai országok településeinek lakosságát! 

--69
--Egy pusztító vírus szedte áldozatait Afrika nagyvárosaiban. Felezze meg azon afrikai települések lakosságát, amelyeknek aktuális
--lakossága meghaladja a félmillió f?t!

--70.
--Cégünk adminisztrátora elkövetett egy nagy hibát. A 2021 júliusában Algeciras kiköt?jéb?l induló utakat tévesen
--Vitte be az adatbázisba, mintha azok Valenciából indultak volna. Valóban Valenciából egyetlen út sem indult a kérdéses id?pontban
--Korrigálja az adminisztrátor hibáját! Az egyszer?ség kedvéért feltételezzük, hogy 1-1 ilyen város létezik, egy kiköt?vel


--71.
--Hozzon létre nézetet, amely listázza az utak minden attribútumát, kiegészítve az indulási és érkezési kiköt? helység és országnevével.


--74. Hozzon létre nézetet, amely listázza a megrendelések összes attribútumát, kiegészítve az indulási és érkezési kiköt?
--helységnevével és országával
CREATE VIEW megrendeles AS;
SELECT *
FROM HAJO.s_megrendeles;
        

--75
--Hozzon létre nézetet, amely listázza, hogy az egyes hajótípusokhoz tartozó hajók összesen hány utat teljesítettek! 
--A listában szerepeljen a hajótípusok azonosítója, neve és a teljesített utak száma! 
--Azokat a hajótípusokat is tüntesse fel az eredményben, amelyekhez egyetlen hajó sem tartozik, 
--és azokat is, amelyekhez tartozó hajók egyetlen utat sem teljesítettek! 
--A lista legyen a hajótípus neve szerint rendezett!

--76.
--Hozzon létre nézetet, amely listázza, hogy az egyes kiköt?knek hány telefonszáma van. A lista tartalmazza a kiköt?k azonosítóját,
--a helység nevét és oszágát és a telefonok számát. Azokat is tüntessük fel, aminek nincs telefonszáma


--78.
--Hozzon létre nézetet, amely listázza, hogy az egyes kiköt?kre hány út vezetett: kiköt?k azonosítója, helységük neve, országa, utak száma
--Azokat is tüntessük fel, ahova egyetlen út sem vezetett!


--from hajo.s_helyseg h right outer join hajo.s_kikoto k on h.helyseg_id = k.helyseg
--from hajo.s_kikoto k left outer join hajo.s_helyseg h on h.helyseg_id = k.helyseg


--80
--Egy nézetet, amely kilistázza, hogy az egyes kiköt?k hány megrendelésben szerepeltek célpontként! A lista tartalmazza kiköt?k id-jét, helységek
--nevét és országát és a megrendelések számát

--81. 
--Hozzon létre nézetet, amely megadja a legnagyobb forgalmú kiköt?(k) azonosítóját, helységnevét és országát! A legnagyobb
--forgalmú kiköt? az, amelyik a legtöbb út indulási vagy érkezési kiköt?je volt.

--82
--Hozzon létre nézetet, amely megadja annak a hajónak az azonosítóját és nevét, 
--amelyik a legnagyobb összsúlyt szállította a 2021 májusában induló utakon! 
--Ha több ilyen hajó is van, akkor mindegyiket listázza!


--83
--Hozzon létre nézetet, ami megadja a kiköt? azonosítóját, helységnevét, országát, amelykb?l kiinduló utakon
--szállított konténerek összesúlya  a legnagyobb. Ha több ilyen van, akkor mindegyiket listázza

--84.
--Hozzon létre nézetet, amely megadja annak a kiköt?nek az azonosítóját, helységnevét, és országát, ameylikbe tartó utakon
--szállított konténerek összsúlya a legnagyobb. 


--86.
--Hozzon létre nézetet amely megadja azoknak az utaknak az adatait, amelyeken a rakomány súlya (a szállított konténerek és a
--rakományaik összsúlya) nem haladja meg a hajó maximális súlyterhelésének a felét! Az út adatai mellett tüntesse fel a hajó nevét és maximális súlyterhelését
--Valamint a rakomány súlyát is



--88.
--Hozzon létre nézetet, amely megadja annak a megrendelésnek az adatait, amelynek a teljesítéséhez a legtöbb útra volt szükség! Ha több
--Ilyen megrendelés is van, akkor mindegyiket listázza!
SELECT *
FROM HAJO.s_megrendeles;
--92.
--Adjon hivatkozási jogosultságot panovicsnak az ön s_ut táblájának indulasi_ido és hajo oszlopaiba
GRANT REFERENCES(indulasi_ido,hajo) ON HAJO.s_ut TO panovics;

--94
--Adjon módosítási jogosultságot a 'panovics' felhasználónak az ön s_ugyfel táblájának vezeték és keresztnév oszlopaira
GRANT UPDATE(vezeteknev,keresztnev) ON HAJO.s_ugyfel TO panovics;

--95
--Adjon beszúrási jogosultságot minden felhasználónak 
--az ön 's_kikoto' táblájának a 'kikoto_id' és 'helyseg' oszlopaira!
GRANT INSERT(kikoto_id,helyseg) ON HAJO.s_kikoto TO PUBLIC;

--96
--Vonja vissza a lekérdezési jogosultságot a 'panovics' felhasználótól az ön s_ut táblájából
REVOKE SELECT ON s_ut FROM panovics;

--98
--Vonja vissza a törlési és módosítási jogosultságot a 'panovics' nev? felhasználótól az ön s_kikoto táblájáról
REVOKE DELETE, UPDATE  ON HAJO.s_kikoto FROM panovics;


--99
--Vonja vissza a törlési jogot 'panovics' felhasználótól az ön s_orszag táblájáról
REVOKE DELETE ON s_orszag FROM panovics;

--100
--Vonja vissza a beszúrási jogosultságot minden felhasználótól az ön s_megrendelés táblájáról
REVOKE INSERT ON HAJO.s_megrendeles FROM PUBLIC;