% Feladat no 5
cla()
clear
syms u v



p1 = [0,0,0];
p2 = [0,1,1];
r1 = [1,0,1];
r2 = [1,1,0];


px(u) = (1-u)*p1(1)+u*p2(1);
py(u) = (1-u)*p1(2)+u*p2(2);
pz(u) = (1-u)*p1(3)+u*p2(3);


rx(u) = (1-u)*r1(1)+u*r2(1);
ry(u) = (1-u)*r1(2)+u*r2(2);
rz(u) = (1-u)*r1(3)+u*r2(3);

sx(u,v) = (1-v)*px(u) + v*rx(u);
sy(u,v) = (1-v)*py(u) + v*ry(u);
sz(u,v) = (1-v)*pz(u) + v*rz(u);


fsurf(sx, sy, sz, [0 1 0 1])
axis equal;
hold on;

fplot3(px, py, pz, [0 1], "r","LineWidth",15)
fplot3(rx, ry, rz, [0 1], "r","LineWidth",15)