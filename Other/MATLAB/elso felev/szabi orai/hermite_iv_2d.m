% DAs feketeleves a Hermite ív létrehozása
cla()
clear

syms t

Px = [2, 4, -2,  5 ];
Py = [-3, 4, -1, 0];

plot(Px, Py, ".b", MarkerSize=30)
axis([-6 6 -6 6])
grid on
hold on

t0 = -2;
t1 = -1;
t2 = 4;
t3 = 5;

syms a0 a1 a2 a3 b0 b1 b2 b3 

x(t) = a3*t^3 + a2*t^2 + a1*t + a0;
y(t) = b3*t^3 + b2*t^2 + b1*t + b0;

% xd(t) = diff(x, t);
% yd(t) = diff(y, t);

ee = [Px(1)==x(t0) ...
      Px(2)==x(t1) ...
      Px(3)==x(t2) ...
      Px(4)==x(t3)];

ek = [Py(1)==y(t0) ...
      Py(2)==y(t1) ...
      Py(3)==y(t2) ...
      Py(4)==y(t3)];

a = solve(ee, [a0, a1, a2, a3]);
b = solve(ek, [b0, b1, b2, b3]);

aa = subs(x, [a0, a1, a2, a3], [a.a0, a.a1, a.a2, a.a3]);
bb = subs(y, [b0, b1, b2, b3], [b.b0, b.b1, b.b2, b.b3]);

fplot(aa,bb, [t0, t3], LineWidth=3)
axis equal