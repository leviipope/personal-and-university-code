clear

syms t a0 a1 a2 a3 x b0 b1 b2 b3

px = [-2 6 10];
py = [-2 -2 2];

v = [6 -4];

plot(px,py,'r.','MarkerSize',10)
axis equal; hold on; grid on; box off;

quiver(px(1),py(1),v(1),v(2),'r')

tk = [0 1 1.5];

x(t) = a3*t^3 + a2*t^2 + a1*t + a0;
y(t) = b3*t^3 + b2*t^2 + b1*t + b0;
xd(t) = diff(x,t);
yd(t) = diff(y,t);
ex = [x(tk(1)) == px(1),...
      xd(tk(1)) == v(1),...
      x(tk(2)) == px(2),...
      x(tk(3)) == px(3)];

ey = [y(tk(1)) == py(1),...
      yd(tk(1)) == v(2),...
      y(tk(2)) == py(2),...
      y(tk(3)) == py(3)];

sx = solve(ex,[a0 a1 a2 a3]);
sy = solve(ey,[b0 b1 b2 b3]);

rx(t) = subs(x,[a0 a1 a2 a3],[sx.a0 sx.a1 sx.a2 sx.a3]);
ry(t) = subs(y,[b0 b1 b2 b3],[sy.b0 sy.b1 sy.b2 sy.b3]);

fplot(rx,ry,[tk(1), tk(3)],"g")


