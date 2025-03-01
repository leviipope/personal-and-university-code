cla()
clear
syms x
f(x) = sin(x);

fplot(f(x), [-2*pi, 2*pi], "g", "LineWidth", 3);
hold on
grid on
axis([-2*pi, 2*pi, -1.1, 1.1])

P = [1, f(1)];
plot(P(1), P(2), ".r", "MarkerSize", 20)

fd(x) = diff(f(x), x);
%fplot(fd(x), [-2*pi, 2*pi], "b", "LineWidth", 3);

e(x) = fd(P(1))*(x-P(1))+P(2);
fplot(e(x), "r", "LineWidth",3)

% fdd(x) = diff(fd(x), x);
% fplot(fdd(x), LineWidth=3)
% 
% Pd = [-1, fd(-1)];
% plot(Pd(1), Pd(2), "*b", MarkerSize=20)
% 
% ed(x) = fdd(Pd(1))*(x-Pd(1))+Pd(2);
% quiver(Pd(1), Pd(2), Pd(1)+1, ed(Pd(1)+1));
% % fplot(ed(x), "c", "LineWidth",3)

axis equal
