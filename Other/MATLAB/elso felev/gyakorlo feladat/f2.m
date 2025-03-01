% Feladat no 2
cla()
clear

syms x y

z(x,y) = sqrt(1-x^2-0.5*y^2);

fsurf(z)
axis equal; hold on;

x0 = 0.5;
y0 = 0.2;

p = [x0, y0, z(x0, y0)];

plot3(p(1), p(2), p(3), ".r", markersize=20)

