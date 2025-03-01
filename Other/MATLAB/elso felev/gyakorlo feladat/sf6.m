clear

syms a0 a1 a2 a3 a4 b0 b1 b2 b3 b4 t x y
axis equal; box off; grid on; hold on;

a = [10 20 40 50 20];
b = [20 40 40 20 10];
plot(a,b,'*')

tk=[0 1 2 3 4];
x(t) = a4*t^4 + a3*t^3 + a2*t^2 + a1*t + a0;
y(t) = b4*t^4 + b3*t^3 + b2*t^2 + b1*t + b0;

ex = [x(tk(1)) == a(1),...
      x(tk(2)) == a(2),...
      x(tk(3)) == a(3),...
      x(tk(4)) == a(4),...
      x(tk(5)) == a(5)];
ey = [y(tk(1)) == b(1),...
      y(tk(2)) == b(2),...
      y(tk(3)) == b(3),...
      y(tk(4)) == b(4),...
      y(tk(5)) == b(5)];

sx = solve(ex, [a0 a1 a2 a3 a4]);
sy = solve(ey, [b0 b1 b2 b3 b4]);

rx(t) = subs(x, [a0 a1 a2 a3 a4 ], [sx.a0 sx.a1 sx.a2 sx.a3 sx.a4]);
ry(t) = subs(y, [b0 b1 b2 b3 b4 ], [sy.b0 sy.b1 sy.b2 sy.b3 sy.b4]);

fplot(rx,ry, [tk(1) tk(5)],'r','LineWidth',2);

% Erinto


rxd(t) = diff(rx,t);
ryd(t) = diff(ry,t);
t0 = 0.5;
p = [rx(t0),ry(t0)];
v = [rxd(t0),ryd(t0)];
plot(p(1), p(2), ".b", markersize=20)
quiver(p(1), p(2), v(1), v(2), "g",'LineWidth',5)

