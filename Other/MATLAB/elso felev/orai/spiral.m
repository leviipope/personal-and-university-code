clear
syms t
x(t) = t*cos(t);
y(t) = t*sin(t);
fplot(x(t),y(t),[0 20*pi])
axis equal

%PONT
t0 = 40;
P = [x(t0),y(t0)];
hold on
plot(P(1),P(2),'k*')

%ERINTO VEKTOR
xd(t) = diff(x(t),t);
yd(t) = diff(y(t),t);
v = [xd(t0), yd(t0)];
quiver(P(1),P(2),v(1),v(2),'r')
