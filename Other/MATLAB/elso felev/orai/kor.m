clear
syms x y
A = [2 3]; r = 4;
F(x,y) = (x-A(1))^2 + (y-A(2))^2-r^2;
fimplicit(F, [0 10 -10 10])
axis equal
F(4,3)
