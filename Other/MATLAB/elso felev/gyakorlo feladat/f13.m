% Feladat no 13

%% 12. feladat
cla()
clear

px = [10 20 40 50 20];
py = [20 40 40 20 10];
n = 4;

syms t

plot(px, py, ".--r", markersize=20);
hold on;
axis equal;

cx(t) = 0*t;
cy(t) = 0*t;
b(t) = 0*t;

for i = 0:n
    b(t) = nchoosek(n, i) * t^i*(1-t)^(n-i);
    cx(t) = cx(t) + b(t) * px(i+1);
    cy(t) = cy(t) + b(t) * py(i+1);
end

fplot(cx, cy, [0 1], "c")

kv = [n*(px(2) - px(1)), n*(py(2) - py(1))];
vv = [n*(px(5) - px(4)), n*(py(5) - py(4))];

quiver(px(1), py(1), kv(1), kv(2), "g")
quiver(px(5), py(5), vv(1), vv(2), "g")

cxd(t) = diff(cx, t);
cyd(t) = diff(cy, t);

% Kis ellenőrzés . . . 
% vv = [cxd(1), cyd(1)];
% 
% quiver(px(5), py(5), vv(1), vv(2), "r")

%% 13. feladat kezdete

k = 0.5;

px = [20 -40 80];
py = [10 60 -20];
v = [vv(1)*k, vv(2)*k];

plot(px, py, ".r", markersize=20);
quiver(px(1), py(1), v(1), v(2), "b");

syms x t a0 a1 a2 a3

x(t) = a3*t^3 + a2*t^2 + a1*t + a0;

xd(t) = diff(x, t);

tk = [0 1 2];

ex = [x(tk(1)) == px(1), xd(tk(1)) == v(1), ...
      x(tk(2)) == px(2), x(tk(3)) == px(3)];

ey = [x(tk(1)) == py(1), xd(tk(1)) == v(2), ...
      x(tk(2)) == py(2), x(tk(3)) == py(3)];

sx = solve(ex, [a0 a1 a2 a3]);
sy = solve(ey, [a0 a1 a2 a3]);

rx(t) = subs(x, [a0 a1 a2 a3], [sx.a0 sx.a1 sx.a2 sx.a3]);
ry(t) = subs(x, [a0 a1 a2 a3], [sy.a0 sy.a1 sy.a2 sy.a3]);

fplot(rx, ry, [tk(1), tk(3)])