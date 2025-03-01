cla()
clear
syms u v

R = 5;
r = 2;

x(u,v) = (R+r*cos(v))*cos(u);
y(u,v) = (R+r*cos(v))*sin(u);
z(u,v) = r*sin(v)+u;

fsurf(x(u,v),y(u,v),z(u,v),[0 2*pi*3 0 2*pi])
hold on

v0 = 0;
u0 = 8;

plot3(x(u0,v0), y(u0,v0), z(u0,v0), ".b", MarkerSize=20)
fplot3(x(u, v0), y(u, v0), z(u, v0), [0, 2*pi*3], "r", LineWidth=3)
fplot3(x(u0, v), y(u0, v), z(u0, v), [0, 2*pi], "r", LineWidth=3)

xu(u) = x(u, v0);
yu(u) = y(u, v0);
zu(u) = z(u, v0);

xv(v) = x(u0, v);
yv(v) = y(u0, v);
zv(v) = z(u0, v);

xdu(u) = diff(xu, u);
ydu(u) = diff(yu, u);
zdu(u) = diff(zu, u);

xdv(v) = diff(xv, v);
ydv(v) = diff(yv, v);
zdv(v) = diff(zv, v);

P0 = [x(u0,v0), y(u0,v0), z(u0,v0)];

quiver3(P0(1), P0(2), P0(3), xdu(u0), ydu(u0), zdu(u0), "c");

quiver3(P0(1), P0(2), P0(3), xdv(v0), ydv(v0), zdv(v0), "g");

cu = [xdu(u0), ydu(u0), zdu(u0)];
cv = [xdv(v0), ydv(v0), zdv(v0)];

ov = cross(cu, cv); 
% ?vektoriális? szorzás valamilyen 
% a jobbkéz szabály szerinti cucchoz 
% a felületre merőleges vektor létrehozása


quiver3(P0(1), P0(2), P0(3), ov(1), ov(2), ov(3))

axis equal