clear

syms u v
axis equal; box off; grid on; xlabel("x"); ylabel("y"); zlabel("z"); hold on;


x(u,v) = u - (u^3)/3 + u*v^2;
y(u,v) = v - (v^3)/3 + v*u^2;
z(u,v) = u^2 - v^2;

fsurf(x,y,z,[-25 25 -25 25])

u0 = 10; v0 = 15;
p = [x(u0,v0) y(u0,v0) z(u0,v0)];
p
plot3(p(1),p(2),p(3),'*r','MarkerSize',15)

cx(v) = x(u0,v);
cy(v) = y(u0,v);
cz(v) = z(u0,v);
fplot3(cx,cy,cz,[-25 25],'r','LineWidth',4)

dx(u) = x(u,v0);
dy(u) = y(u,v0);
dz(u) = z(u,v0);
fplot3(dx,dy,dz,[-25 25],'r','LineWidth',4)

cxd(v) = diff(cx,v);
cyd(v) = diff(cy,v);
czd(v) = diff(cz,v);
cv = [cxd(v0) cyd(v0) cyd(v0)];

dxd(u) = diff(dx,u);
dyd(u) = diff(dy,u);
dzd(u) = diff(dz,u);
dv = [dxd(u0) dyd(u0) dzd(u0)];

nv = cross(cv,dv);
quiver3(p(1),p(2),p(3),nv(1),nv(2),nv(3),'g')


hossz=(nv(1)^2+nv(2)^2+nv(3)^2)






