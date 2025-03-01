clear
% px = [-2,3,5,8];
% py = [1 7 2 -2];
% plot(px,py,'.r','MarkerSize',12)
% axis([-5 10 -6 8])
% axis equal
% grid on
% ax = gca 
% ax.XAxisLocation = 'origin';
% ax.YAxisLocation = 'origin';
% box off
% % ez egy commment
% 
% clear 
% syms x 
% f(x) = sin(x);
% fplot(f,[-4*pi 3*pi])
% axis([-20,20 -2 2])
% axis equal
% tengelyek;
% g(x) = cos(x)
% %figure
% hold on
% fplot(g)
% p = [5.3, g(5.3)]
% double(P(2))

% clear
% syms x y
% A = [2 3]; r = 4;
% F(x,y) = (x-A(1))^2 + (y-A(2))^2-r^2;
% fimplicit(F, [0 10 -10 10])
% axis equal
% F(4,3)

clear
syms t
x(t) = t*cos(t);
y(t) = t*sin(t);
fplot(x(t),y(t), [0 20*pi])
axis equal
t0 = 40
P = [x(t0),y(t0)];
hold on
plot(P(1), P(2), 'k*')

xd(t) = diff(x(t),t);
yd(t) = diff(y(t),t);
v = [ xd(t0), yd(t0) ];
quiver(P(1),P(2), v(1), v(2),'r')
