% 12
clear
px = [10 20 40 50 20];
py = [20 40 40 20 10];
plot(px,py,"*--")
axis equal;hold on; box off; grid on; xlabel('x'); ylabel('y');

n = 4;
syms t
cx(t) = 0*t;
cy(t) = 0*t;
b(t) = 0*t;

for i = 0:n
    b(t) = nchoosek(n,i) * t^i * (1-t)^(n-i);
    cx(t) = cx(t) + px(i+1) * b(t);
    cy(t) = cy(t) + py(i+1) * b(t);
end
fplot(cx,cy,[0 1])

%erintov

u = [n*(px(2)-px(1)), n*(py(2)-py(1))];
w = [n*(px(5)-px(4)), n*(py(5)-py(4))];
quiver(px(1),py(1),u(1),u(2))
quiver(px(5),py(5),w(1),w(2))

% 13k

px = [20 -40 80];
py = [10 60 40];
plot(px,py,'.g','MarkerSize',15)
k = 0.1;
v = [(k*w(1)), (k*w(2))];
quiver(px(1),py(1),w(1),w(2),'g')

syms t a0 a1 a2 a3 x

x(t) = a3*t^3 + a2*t^2 + a1*t + a0;
xd(t) = diff(x,t);

t0 = 0; t1 = 1; t2 = 2;
ex = [x(t0) == px(1),...
      xd(t0) == v(1),...
      x(t1) == px(2),...
      x(t2) == px(3)];
m = solve(ex,[a3 a2 a1 a0]);
dx(t) = subs(x,[a3 a2 a1 a0],[m.a3 m.a2 m.a1 m.a0]);

ey = [x(t0) == py(1),...
    xd(t0) == v(2),...
    x(t1) == py(2),...
    x(t2) == py(3)];
m = solve(ey,[a3 a2 a1 a0]);
dy(t) = subs(x,[a3 a2 a1 a0],[m.a3 m.a2 m.a1 m.a0]);
fplot(dx,dy,[t0 t2],'c')






