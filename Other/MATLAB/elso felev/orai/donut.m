clear
syms u v
R = 5; r = 2;
x(u,v) = (R + r*cos(v))*cos(u);
y(u,v) = (R + r*cos(v))*sin(u);
z(u,v) = r*sin(v);
fsurf(x,y,z,[0 2*pi 0 2*pi])
axis equal

% RAJTA PONT

u0 = 4.4; v0 = 1;
P = [x(u0,v0),y(u0,v0),z(u0,v0)];
hold on
plot3(P(1),P(2),P(3),'.r','MarkerSize',20)

% térgömb a donuton

cx(v) = x(u0,v);
cy(v) = y(u0,v);
cz(v) = z(u0,v);
fplot3(cx,cy,cz,[0 2*pi],'b','LineWidth',3)

% erintovektor
cxd(v) = diff(cx,v);
cyd(v) = diff(cy,v);
czd(v) = diff(cz,v);
ce = [cxd(v0),cyd(v0),czd(v0)];
quiver3(P(1),P(2),P(3),ce(1),ce(2),ce(3),'r','LineWidth',3)

% masik tergorbe
dx(u) = x(u,v0);
dy(u) = y(u,v0);
dz(u) = z(u,v0);
fplot3(dx,dy,dz,[0 2*pi],'g','LineWidth',3)

% masik erintovektor

dxd(u) = diff(dx,u);
dyd(u) = diff(dy,u);
dzd(u) = diff(dz,u);
de = [dxd(u0),dyd(u0),dzd(u0)];
quiver3(P(1),P(2),P(3),de(1),de(2),de(3),'r','LineWidth',3)

% vektorialis szorzat
n = cross(de, ce);
quiver3(P(1),P(2),P(3),n(1),n(2),n(3),'k','LineWidth',3)
