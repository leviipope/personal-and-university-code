clear
syms u v
axis equal; hold on; box off; grid on;

p1 = [0 0 0];
p2 = [0 1 1];
r1 = [1 0 1];
r2 = [1 1 0];

px(u) = (1-u)*p1(1)+u*p2(1);
py(u) = (1-u)*p1(2)+u*p2(2);
pz(u) = (1-u)*p1(3)+u*p2(3);


rx(u) = (1-u)*r1(1)+u*r2(1);
ry(u) = (1-u)*r1(2)+u*r2(2);
rz(u) = (1-u)*r1(3)+u*r2(3);

fplot3(px, py, pz, [0 1], "r","LineWidth",15)
fplot3(rx, ry, rz, [0 1], "r","LineWidth",15)

sx(u,v) = (1-v)*px+v*rx;
sy(u,v) = (1-v)*py+v*ry;
sz(u,v) = (1-v)*pz+v*rz;

fsurf(sx, sy, sz,[0 1 0 1])