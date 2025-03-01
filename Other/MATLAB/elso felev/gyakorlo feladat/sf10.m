clear

px = [-2 6];
py = [-2 -2];
vx = [6 4];
vy = [-4 4];
syms t x y a0 a1 a2 a3 b0 b1 b2 b3
plot(px,py,'r.','MarkerSize',15)
axis equal; box off, hold on; grid on;

quiver(px(1),py(1),vx(1),vy(1),'r')
quiver(px(2),py(2),vx(2),vy(2),'r')

tk = [0 1];

x(t) = a3*t^3 + a2*t^2 + a1*t + a0;
y(t) = b3*t^3 + b2*t^2 + b1*t + b0;

xd(t) = diff(x,t);
yd(t) = diff(y,t);

ex = [x(tk(1)) == px(1),...
      xd(tk(1)) == vx(1),...
      x(tk(2)) == px(2),...
      xd(tk(2)) == vx(2)];
ey = [y(tk(1)) == py(1),...
      yd(tk(1)) == vy(1),...
      y(tk(2)) == py(2),...
      yd(tk(2)) == vy(2)];

sx = solve(ex,[a0 a1 a2 a3]);
sy = solve(ey,[b0 b1 b2 b3]);

cx(t) = subs(x,[a0 a1 a2 a3], [sx.a0 sx.a1 sx.a2 sx.a3]);
cy(t) = subs(y,[b0 b1 b2 b3], [sy.b0 sy.b1 sy.b2 sy.b3]);

fplot(cx, cy, [tk(1), tk(2)], 'g')

% 10.feladat kezdete igazabol

rx = [px(2) 14];
ry = [py(2) -4];
plot(rx,ry,'.b','MarkerSize',15)

ux = [vx(2) 3];
uy = [vy(2) 0];
quiver(rx(1), ry(1), ux(1), uy(1))
quiver(rx(2), ry(2), ux(2), uy(2))

tk = [0 1 0 2];

e = [x(tk(3)) == rx(1),...
     x(tk(4)) == rx(2),...
     xd(tk(3)) == ux(1),...
     xd(tk(4)) == ux(2)];
m = solve(e,[a3 a2 a1 a0]);
dx(t) = subs(x,[a3 a2 a1 a0], [m.a3 m.a2 m.a1 m.a0]);

e = [y(tk(3)) == ry(1),...
     y(tk(4)) == ry(2),...
     yd(tk(3)) == uy(1),...
     yd(tk(4)) == uy(2)];
m = solve(e,[b3 b2 b1 b0]);
dy(t) = subs(y,[b3 b2 b1 b0], [m.b3 m.b2 m.b1 m.b0]);

fplot(dx,dy,[tk(3), tk(4)],'g','LineWidth',4)

    











