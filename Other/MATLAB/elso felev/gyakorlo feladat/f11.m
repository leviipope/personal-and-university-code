%% 7. feladat része
cla()
clear

syms x a0 a1 a2 a3 t

px = [-2 4 6 10];
py = [-2 0 -2 2];

plot(px, py, ".r", markersize=20);
hold on;
axis equal;

tk = [-1 0 2 3];

n = 3;

x(t) = a3*t^3 + a2*t^2 + a1*t + a0;

xd(t) = diff(x, t);

ex = [x(tk(1)) == px(1), x(tk(2)) == px(2), ...
      x(tk(3)) == px(3), x(tk(4)) == px(4)];

ey = [x(tk(1)) == py(1), x(tk(2)) == py(2), ...
      x(tk(3)) == py(3), x(tk(4)) == py(4)];

sx = solve(ex, [a0 a1 a2 a3]);
sy = solve(ey, [a0 a1 a2 a3]);

rx(t) = subs(x, [a0 a1 a2 a3], [sx.a0, sx.a1, sx.a2, sx.a3]);
ry(t) = subs(x, [a0 a1 a2 a3], [sy.a0, sy.a1, sy.a2, sy.a3]);

fplot(rx, ry, [tk(1), tk(n+1)])

rxd(t) = diff(rx, t);
ryd(t) = diff(ry, t);

t0 = 2;
p = [rx(t0), ry(t0)];
plot(p(1), p(2), ".b", markersize=20)
v = [rxd(t0), ryd(t0)];
quiver(p(1), p(2), v(1), v(2), "c")

%% 11. feladat kezdete

% érintő vektor kalkulálása
k = 0.4;

px1 = [px(4) 14];
py1 = [py(4) -4];
vx1 = [rxd(tk(4))*k 3];
vy1 = [ryd(tk(4))*k 0];
% Ez nem tudom mi a túróé nem ugyanolyan a kettő
% Direkt a másikból van referálva idk
% 22:56 van, nincs kedvem többet gondolkozni rajta


tk = [0 2];

plot(px1, py1, ".b", MarkerSize=20);
quiver(px1, py1, vx1, vy1, "c")

ex = [x(tk(1)) == px1(1), xd(tk(1)) == vx1(1), ...
      x(tk(2)) == px1(2), xd(tk(2)) == vx1(2)];

ey = [x(tk(1)) == py1(1), xd(tk(1)) == vy1(1), ...
      x(tk(2)) == py1(2), xd(tk(2)) == vy1(2)];

sx = solve(ex, [a0 a1 a2 a3]);
sy = solve(ey, [a0 a1 a2 a3]);

hx(t) = subs(x, [a0 a1 a2 a3], [sx.a0, sx.a1, sx.a2, sx.a3]);
hy(t) = subs(x, [a0 a1 a2 a3], [sy.a0, sy.a1, sy.a2, sy.a3]);

fplot(hx, hy, [tk(1), tk(2)], "r")
