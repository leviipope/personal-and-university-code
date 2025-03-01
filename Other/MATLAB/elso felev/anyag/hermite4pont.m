clear
px = [ 1 4 6 7 ]; py = [ -1 4 5 2 ];
plot(px, py, '*');
axis([0 10 -2 7]); axis equal;
t1 = -1; t2 = 2; t3 = 3; t4 = 4.5;

% syms t a3 a2 a1 a0 b3 b2 b1 b0
% e = [ a3 * t1^3 + a2 * t1^2 + a1 * t1 + a0 == px(1), ...
%       a3 * t2^3 + a2 * t2^2 + a1 * t2 + a0 == px(2), ...
%       a3 * t3^3 + a2 * t3^2 + a1 * t3 + a0 == px(3), ...
%       a3 * t4^3 + a2 * t4^2 + a1 * t4 + a0 == px(4)];
% m = solve(e, [a3 a2 a1 a0])
% cx(t) = m.a3 * t^3 + m.a2 * t^2 + m.a1 * t + m.a0

syms t a3 a2 a1 a0 b3 b2 b1 b0
x(t) = a3 * t^3 + a2 * t^2 + a1 * t + a0;

e = [ x(t1) == px(1), x(t2) == px(2), ...
      x(t3) == px(3), x(t4) == px(4)];
m = solve(e, [a3 a2 a1 a0]);
cx(t) = subs(x, [a3 a2 a1 a0], [m.a3 m.a2 m.a1 m.a0]);

y(t) = b3 * t^3 + b2 * t^2 + b1 * t + b0;
e = [ y(t1) == py(1), y(t2) == py(2), ...
      y(t3) == py(3), y(t4) == py(4)];
m = solve(e, [b3 b2 b1 b0]);
cy(t) = subs(y, [b3 b2 b1 b0], [m.b3 m.b2 m.b1 m.b0]);

hold on; axis equal; box off; grid on;
fplot(cx, cy, [t1 t4])






