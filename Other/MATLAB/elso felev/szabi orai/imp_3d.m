cla()
clear

syms x y

z(x,y) = sin(x)*cos(y);

fsurf(z)
hold on

P = [0,0,z(0,0)];
fplot3(P(1), P(2), P(3), ".r", MarkerSize=30)

zxd(y) = diff(z(x,y), x);
zyd(x) = diff(z(x,y), y);

axis([-5 5 -5 5])
% quiver3(P(1), P(2), zxd(P(2)), zyd(P(1)));
% ÉRINTŐ ILYENKOR WTF???
axis equal