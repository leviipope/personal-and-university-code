% Feladat no 1
cla()
clear

syms u v

x(u,v) = u-(u^3)/3+u*v^2;
y(u,v) = v-(v^3)/3+ v * u^2;
z(u,v) = u^2-v^2;

fsurf(x,y,z, [-25 25 -25 25])
axis equal; % Ez KELL!!! CSAK DEBUGHOZ VAN KISZEDVE
hold on;

u0 = 10;
v0 = 15;

px = x(u0, v0);
py = y(u0, v0);
pz = z(u0, v0);

P = [px, py, pz];

plot3(px, py, pz, "*r", 'MarkerSize',20)

xv(v) = x(u0, v);
yv(v) = y(u0, v);
zv(v) = z(u0, v);

xu(u) = x(u, v0);
yu(u) = y(u, v0);
zu(u) = z(u, v0);

fplot3(xv, yv, zv, [-25 25], "r")
fplot3(xu, yu, zu, [-25 25], "r")

xvd(v) = diff(xv, v);
yvd(v) = diff(yv, v);
zvd(v) = diff(zv, v);

xud(u) = diff(xu, u);
yud(u) = diff(yu, u);
zud(u) = diff(zu, u);


vv = [xvd(v0), yvd(v0), zvd(v0)];
uv = [xud(u0), yud(u0), zud(u0)];

% quiver3(px, py, pz, vv(1), vv(2), vv(3), "b", 'LineWidth',5)
% quiver3(px, py, pz, uv(1), uv(2), uv(3), "b", 'LineWidth',5)

cr = cross(vv, uv);
% A szent keresztre mindig emlékezz

% quiver3(px, py, pz, cr(1), cr(2), cr(3), "b", linewidth=1)
% Ez a normálvektor I guess elér rusnya

% Ki kell kalkulálni a hosszát ez should be EZ
ki = cr-P;

hossz = sqrt(ki(1)^2+ki(2)^2+ki(3)^2)


