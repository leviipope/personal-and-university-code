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
