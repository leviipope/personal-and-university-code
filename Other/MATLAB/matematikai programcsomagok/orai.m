% elso kod
a=3; b=4;
c=a+b;
 
%sorvektor
a = [1 2 3 4 5];
a(2);

%szabalyos lepekoz eseten ":"
a = [1:4]; % x=elsoelem:utolsoelem, ekkor a lepeskoz 1.
b = [8:-1:2]; % x=elsoelem:lepeskoz:utolsoelem

%linspace
e = linspace(1,2,6); % 6 elemu vektor, elso elem 1, utolso 2, egyforma lepeskoz
e = linspace(1,2); % 100 elemu vektor

size(a); % megadja a matrix sorainak es oszlopainak szamat egy 2 elemu vektorba
numel(a); % matrix emeleinek szama

% n x m-es egyesbol vagy nullasbol allo matrix
ones(1,2);
zeros(3,3);



%oszlopvektor - transzponaljuk a sorvektort vagy ;-vel valasztjuk el
a = [1:5]; b=a'; b;
c = [10;9;8;7];

a = linspace(1,8,16)';
a = [1:0.7:8]';



% muveletek vektorokkal
% vektor darabolas
v = [1:8];
v(2); % vektor masodik eleme
v([2,4]); % vektor 2. es 4. elemebol allo vektor
v(2:4); % vektor 2. 3. 4. elemebol allo vektor
v(end); % vektor utolso eleme
v(2) = []; % elhagyjuk a masodik elemet
v([2,4]) = []; % elhagyjuk 2. 4. elemet
v(2:4) = []; % elhagyjuk 2. 3. 4. elemet

% vektorelemek modositasa
v(2) = -5; % 2. elem -> -5
v([2,4]) = [-5,1]; % 2. elem -> -5, 4. elem -> 1
v([1,3]) = 1; % 1. es 3. elem -> 1
v(6:8) = [1,2,3];
v(5:6) = 0;
% v(11) = 4 eseten 0-val tolti fel az eddig nem letezo helyeket
v(20) = 1;

% vektorok osszefuzese
% addig lehet osszefuzni vektorokat amig az eredmeny teglalap marad
% [a b] vagy [a, b] ket sorvektor osszefuzese
% [1 a 2 3  6] sorvektor bovites
% [a; b] oszlopvektor osszefuzes
% [1;a;6] oszlopvektor bovites

m = [1; 2; 3];
n = [4; 5; 6];
[m,n];
[m;n];

% aritmetikai muveletek vektorokkal
% ha a es b ugyanolyan meretu
a = linspace(1,8,5);
b = linspace(2,7,5);
a+b;
a-b;
a.^2;
a.*b;
a./b;
1./a;

min(a);
max(a);
sort(a);
sort(a, "descend");
flip(a); % forditott sorrendbe sorolja fel, ertek nem valtozik
length(a); % sor vagy oszlopai szama kozul a nagyobb
sum(a);
prod(a); % a elemeinek a szorzata
mean(a); % a elemeinek az atlaga



% matrixok
A=[1,2,3;4,5,6;7,8,9]; % vagy A=[1 2 3;4 5 6;7 8 9];
% matrix letrehozasa vektorok osszefuzesevel
a=[1,2,3]; b=[-4,-5,-6];
B=[a;b];
m=[1;2;3]; n=[7;8;9];
D=[m n];
% matrix bovitese
A; a;
E=[A;a];
A;, m;
F=[A m];
size(F)