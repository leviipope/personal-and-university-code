clear

syms x a0 a1 a2 a3 t

px = [-2 4 6 10];
py = [-2 0 -2 2];

plot(px, py, ".r", markersize=20);
hold on; axis equal;

tk = [-1 0 2 3];

x(t) = a3*t^3 + a2*t^2 + a1*t + a0;

ex = [x(tk(1)) == px(1),...
      x(tk(2)) == px(2),...
      x(tk(3)) == px(3),...
      x(tk(4)) == px(4)];
ey = [x(tk(1)) == py(1),...
      x(tk(2)) == py(2),...
      x(tk(3)) == py(3),...
      x(tk(4)) == py(4)];
sx = solve(ex, [a0 a1 a2 a3]);
sy = solve(ey, [a0 a1 a2 a3]);

rx(t) = subs(x, [a0 a1 a2 a3], [sx.a0 sx.a1 sx.a2 sx.a3]);
ry(t) = subs(x, [a0 a1 a2 a3], [sy.a0 sy.a1 sy.a2 sy.a3]);

fplot(rx, ry, [tk(1), tk(4)])

%ERINTO

rxd(t) = diff(rx,t);
ryd(t) = diff(ry,t);
t0 = 2;
% nem kell t0 mer tk(3) is = 2
p = [rx(tk(3)) ry(tk(3))];
plot(p(1),p(2),'r.','MarkerSize',10)
v = [rxd(tk(3)) ryd(tk(3))];
quiver(p(1), p(2), v(1), v(2),'g','LineWidth',4)

