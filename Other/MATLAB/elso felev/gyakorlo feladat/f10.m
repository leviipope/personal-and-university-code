% Feladat no 10

%% 9. feladat része
cla()
clear

syms x a0 a1 a2 a3 t

px = [-2 6];
py = [-2 -2];

vx = [6, 4];
vy = [-4 4];

plot(px, py, ".r", markersize=20);

hold on;
axis equal;

quiver(px, py, vx, vy, "r")

tk = [0 1];

x(t) = a3*t^3 + a2*t^2 + a1*t + a0;

xd(t) = diff(x, t);

ex = [x(tk(1)) == px(1), xd(tk(1)) == vx(1), ...
      x(tk(2)) == px(2), xd(tk(2)) == vx(2)];

ey = [x(tk(1)) == py(1), xd(tk(1)) == vy(1), ...
      x(tk(2)) == py(2), xd(tk(2)) == vy(2)];

sx = solve(ex, [a0 a1 a2 a3]);
sy = solve(ey, [a0 a1 a2 a3]);

rx(t) = subs(x, [a0 a1 a2 a3], [sx.a0 sx.a1 sx.a2 sx.a3]);
ry(t) = subs(x, [a0 a1 a2 a3], [sy.a0 sy.a1 sy.a2 sy.a3]);

fplot(rx, ry, [tk(1), tk(2)], "b");

%% 10. feladat kezdete
% hiiiiii
px1 = [px(2) 14];
py1 = [py(2) -4];
vx1 = [vx(2) 3];
vy1 = [vy(2) 0];
% Ez nem tudom mi a túróé nem ugyanolyan a kettő
% Direkt a másikból van referálva idk
% 22:56 van, nincs kedvem többet gondolkozni rajta


tk = [0 2];

plot(px1, py1, ".b", 'MarkerSize',45);
quiver(px1, py1, vx1, vy1, "c")
quiver(px(2), py(2), vx(2), vy(2), "b")

ex = [x(tk(1)) == px1(1), xd(tk(1)) == vx1(1), ...
      x(tk(2)) == px1(2), xd(tk(2)) == vx1(2)];

ey = [x(tk(1)) == py1(1), xd(tk(1)) == vy1(1), ...
      x(tk(2)) == py1(2), xd(tk(2)) == vy1(2)];

sx = solve(ex, [a0 a1 a2 a3]);
sy = solve(ey, [a0 a1 a2 a3]);

hx(t) = subs(x, [a0 a1 a2 a3], [sx.a0, sx.a1, sx.a2, sx.a3]);
hy(t) = subs(x, [a0 a1 a2 a3], [sy.a0, sy.a1, sy.a2, sy.a3]);

fplot(hx, hy, [tk(1), tk(2)], "r")
