clear
px = [1 6 8 11];
py = [2 8 7 1 ];
plot(px,py,'*--');
axis equal; hold on;
xlabel("x")
n = 3;
syms t
cx(t) = 0*t;
cy(t) = 0*t;
for i = 0 : n
    b(t) = nchoosek(n,i) * t^i * (1-t)^(n-i);
    cx(t) = cx(t) + px(i+1) * b(t);
    cy(t) = cy(t) + py(i+1) * b(t);
end
fplot(cx,cy,[0 1])
u = [n * (px(2)-px(1)), n * (py(2)-py(1))];
quiver(px(1), py(1), u(1), u(2))
v = [n * (px(4)-px(3)), n * (py(4)-py(3))];
quiver(px(4), py(4), v(1), v(2))
%%%%%%%%%%%%%%%
m = 5;
rx = [px(4), px(4) + v(1)/m, 30, 35, 32, 26];
ry = [py(4), py(4) + v(2)/m, -8,  -3,  0, 2];
plot(rx,ry,'*--')
%%%%%
dx(t) = 0*t;
dy(t) = 0*t;
for i = 0 : m
    b(t) = nchoosek(m,i) * t^i * (1-t)^(m-i);
    dx(t) = dx(t) + rx(i+1) * b(t);
    dy(t) = dy(t) + ry(i+1) * b(t);
end
fplot(dx,dy,[0 1])
