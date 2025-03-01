clear
px = [ 2 6 ]; py = [ 1 2 ];
plot(px, py, '*');

axis([-4 14 -2 12]), axis equal; hold on;

vx = [ 3 0 ]; vy = [ 8 10 ];
quiver(px(1), py(1), vx(1), vy(1));
quiver(px(2), py(2), vx(2), vy(2));

syms t a3 a2 a1 a0 b3 b2 b1 b0

t1 = 1; t2 = 2;

x(t) = a3 * t^3 + a2 * t^2 + a1 * t + a0;
xd(t) = diff(x, t);

e = [ x(t1) == px(1), x(t2) == px(2), ...
     xd(t1) == vx(1), xd(t2) == vx(2)];
m = solve(e, [a3 a2 a1 a0]);
cx(t) = subs(x, [a3 a2 a1 a0], [m.a3 m.a2 m.a1 m.a0]);


y(t) = b3 * t^3 + b2 * t^2 + b1 * t + b0;
yd(t) = diff(y, t);

e = [ y(t1) == py(1), y(t2) == py(2), ...
     yd(t1) == vy(1), yd(t2) == vy(2)];

m = solve(e, [b3 b2 b1 b0]);
cy(t) = subs(y, [b3 b2 b1 b0], [m.b3 m.b2 m.b1 m.b0]);

fplot(cx, cy, [t1 t2])




