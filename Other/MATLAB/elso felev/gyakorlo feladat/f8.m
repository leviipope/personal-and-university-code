% Feladat no 8
cla()
clear

syms x a0 a1 a2 a3 t

px = [-2 6 10];
py = [-2 -2 2];

v = [6 -4];

n = 3;

plot(px, py, ".r", markersize=20);
hold on;
axis equal;
quiver(px(1), py(1), v(1), v(2), "r");

tk = [0 1 1.5];

x(t) = a3*t^3 + a2*t^2 + a1*t + a0;
% HIVATALOSAN kellene egy y(t) is b0 b1 b2 b3 változókkal
% De kihagytam, mert ugyan az a képlet, és így
% kevesebbet kell gépelni


xd(t) = diff(x, t);

ex = [x(tk(1)) == px(1), xd(tk(1)) == v(1), ...
      x(tk(2)) == px(2), x(tk(3)) == px(3)];

ey = [x(tk(1)) == py(1), xd(tk(1)) == v(2), ...
      x(tk(2)) == py(2), x(tk(3)) == py(3)];

sx = solve(ex, [a0 a1 a2 a3]);
sy = solve(ey, [a0 a1 a2 a3]);

rx(t) = subs(x, [a0 a1 a2 a3], [sx.a0 sx.a1 sx.a2 sx.a3]);
ry(t) = subs(x, [a0 a1 a2 a3], [sy.a0 sy.a1 sy.a2 sy.a3]);

fplot(rx, ry, [ tk(1), tk(n)], "g")