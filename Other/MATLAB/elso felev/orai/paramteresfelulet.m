clear
syms u v
x(u,v) = cos(u);
y(u,v) = sin(u);
z(u,v) = v;
m = 3;
fsurf(x,y,z,[0 2*pi 0 m])
axis equal

%PONT
u0 = pi/2; v0 = 2;
P = [x(u0,v0),y(u0,v0),z(u0,v0)];
hold on
plot3(P(1),P(2),P(3),'r.','MarkerSize',15)