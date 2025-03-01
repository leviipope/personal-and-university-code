clear
syms t
x(t) = cos(t)*t;
y(t) = sin(t)*t;
z(t) = t;
fplot3(x,y,z,[0 18*pi])
axis equal
xlabel('x');ylabel('y');zlabel('z');

%PONT
t0 = 46;
P = [x(t0),y(t0),z(t0)];
hold on 
plot3(P(1),P(2),P(3),'.r',"MarkerSize",14)

%ERINTO VEKTOR
xd(t) = diff(x,t);
yd(t) = diff(y,t);
zd(t) = diff(y,t);
v = [xd(t0),yd(t0),zd(t0)];
quiver3(P(1),P(2),P(3),v(1),v(2),v(3),'b','LineWidth',3)