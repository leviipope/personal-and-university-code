clear

syms u v

x(u,v) = u-(u^3/3)+u*v^2;
y(u,v) = v-(v^3/3)+ v * u^2;
z(u,v) = u^2-v^2;

% fsurf(x,y,z, [-25 25 -25 25])
axis equal; hold on;

u0 = 10;
v0 = 15;
px = x(u0, v0);
py = y(u0, v0);
pz = z(u0, v0);
P = [px,py,pz];
% plot3(px,py,pz,'r*','MarkerSize',40)

xv(v) = x(u0, v);
yv(v) = y(u0, v);
zv(v) = z(u0, v);
xu(u) = x(u, v0);
yu(u) = y(u, v0);
zu(u) = z(u, v0);
% fplot3(xv, yv, zv, [-25 25], "r",'LineWidth',3)
% fplot3(xu, yu, zu, [-25 25], "r",'LineWidth',3)

xvd(v) = diff(xv, v);
yvd(v) = diff(yv, v);
zvd(v) = diff(zv, v);
xud(u) = diff(xu, u);
yud(u) = diff(yu, u);
zud(u) = diff(zu, u);
vv = [xvd(v0), yvd(v0), zvd(v0)];
uv = [xud(u0), yud(u0), zud(u0)];
quiver3(px, py, pz, vv(1), vv(2), vv(3), "b", 'LineWidth',5)
quiver3(px, py, pz, uv(1), uv(2), uv(3), "b", 'LineWidth',5)
n = cross(vv, uv);
quiver3(px, py, pz, n(1), n(2), n(3), "b", 'LineWidth',5)
nh = n-P;
hossz = sqrt(nh(1)^2+nh(2)^2+nh(3)^2);
