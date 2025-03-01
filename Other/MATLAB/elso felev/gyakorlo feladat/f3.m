% Feladat no 3
cla()
clear

syms x y z

zz(x,y) = sin(x)+(cos(y)/x);

fsurf(zz, [0.1 5 -6 6])
axis equal;
hold on;

% vv(x,y,z) = sin(x)+(cos(y)/x)-z;
% v(x,y) = vv(x,y,2);

fimplicit(zz, [0.1 5 -6 6], "r", linewidth=5)


% HOGY KŐŐŐ???
