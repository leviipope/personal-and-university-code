%% 6. feladat
cla()
clear

syms a0 a1 a2 a3 a4 b0 b1 b2 b3 b4 t x y

xx = [10 20 40 50 20];
yy = [20 40 40 20 10];

plot(xx,yy,".r", markersize=20)
hold on;
axis equal;

tk = [0 1 2 3 4];
n = 4;

x(t) = a4*t^4 + a3*t^3 + a2*t^2 + a1*t + a0;
y(t) = b4*t^4 + b3*t^3 + b2*t^2 + b1*t + b0;

ex = [x(tk(1)) == xx(1), ...
      x(tk(2)) == xx(2), ...
      x(tk(3)) == xx(3), ...
      x(tk(4)) == xx(4), ...
      x(tk(5)) == xx(5)];

ey = [y(tk(1)) == yy(1), ...
      y(tk(2)) == yy(2), ...
      y(tk(3)) == yy(3), ...
      y(tk(4)) == yy(4), ...
      y(tk(5)) == yy(5)];

sx = solve(ex, [a0 a1 a2 a3 a4]);
sy = solve(ey, [b0 b1 b2 b3 b4]);

rx(t) = subs(x, [a0 a1 a2 a3 a4], [sx.a0 sx.a1 sx.a2 sx.a3 sx.a4]);
ry(t) = subs(y, [b0 b1 b2 b3 b4], [sy.b0 sy.b1 sy.b2 sy.b3 sy.b4]);

fplot(rx, ry, [tk(1) tk(n+1)]);

% EZ katasztrófa... 21:51 van és 6. feladatnál járok a 15 ből
% 21 előtt kezdtem XD
% Bruh még kell egy érintő is :)

rxd(t) = diff(rx, t);
ryd(t) = diff(ry, t);

t0 = 0.5;

p = [rx(t0), ry(t0)];

v = [rxd(t0), ryd(t0)];

plot(p(1), p(2), ".b", markersize=20)

quiver(p(1), p(2), v(1), v(2), "c")

%% 14. feladat kezdete

px = [20 -20 60 80 0];
py = [10 0 -5 60 20];

n = 4;

k = 4; % k lesz az új görbe érintőjének a méretezője

% 2. pont poziciojának kalkulálása történik
v = [(rxd(tk(5))/n) + px(1), (ryd(tk(5)) /n) + py(1)];
w = [rxd(tk(5)), ryd(tk(5))];
quiver(px(1), py(1), w(1), w(2))

px = [20 v(1) 0 2 30];
py = [10 v(2) 0 -10 5];

plot(px, py, ".--c", markersize=20)

cx(t) = 0*t;
cy(t) = 0*t;
b(t) = 0*t;

for i = 0:n
    b(t) = nchoosek(n, i) * t^i * (1-t)^(n-i);

    cx(t) = cx(t) + b(t) * px(i+1);
    cy(t) = cy(t) + b(t) * py(i+1);
end

fplot(cx, cy, [0 1], "r")
