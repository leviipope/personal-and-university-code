cla()
clear

syms t

x(t) = cos(t);
y(t) = sin(t);

fplot(x(t), y(t), [0, 2*pi])
hold on
grid on

t0 = 1;

P = [x(t0), y(t0)];
plot(P(1), P(2), ".r", MarkerSize=20)
fplot(x(t)*0.5+P(1), y(t)*0.5+P(2), [0, 2*pi], "r")

xd(t) = diff(x, t);
yd(t) = diff(y, t);

quiver(P(1), P(2), xd(t0), yd(t0));
syms x
l(x) = (yd(t0)/xd(t0))*(x-P(1)) + P(2);
fplot(l(x))
axis equal