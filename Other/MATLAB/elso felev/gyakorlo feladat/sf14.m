clear 

syms t x a0 a1 a2 a3 a4

px = [10 20 40 50 20];
py = [20 40 40 20 10];
plot(px,py,'.g','MarkerSize',15)
axis([-50 70 -40 60]); axis equal; hold on; box off; grid on; 

t0 = 0; t1 = 1; t2 = 2; t3 = 3; t4 = 4; 

x(t) = a4*t^4 + a3*t^3 + a2*t^2 + a1*t + a0;

e = [x(t0) == px(1),...
     x(t1) == px(2),...
     x(t2) == px(3),...
     x(t3) == px(4),...
     x(t4) == px(5)];
m = solve(e,[a4 a3 a2 a1 a0]);
cx(t) = subs(x,[a4 a3 a2 a1 a0],[m.a4 m.a3 m.a2 m.a1 m.a0]);

e = [x(t0) == py(1),...
     x(t1) == py(2),...
     x(t2) == py(3),...
     x(t3) == py(4),...
     x(t4) == py(5)];
m = solve(e,[a4 a3 a2 a1 a0]);
cy(t) = subs(x,[a4 a3 a2 a1 a0],[m.a4 m.a3 m.a2 m.a1 m.a0]);

fplot(cx,cy,[t0 t4],'r','LineWidth',3)

%14

cxd(t) = diff(cx,t);
cyd(t) = diff(cy,t);
up=[cx(t4) cy(t4)];
uv = [cxd(t4) cyd(t4)];

% hermite iv utolso pontjanak erinto vektora
quiver(up(1),up(2),uv(1),uv(2),'y')

n = 4;
v = [uv(1)/n uv(2)/n];


bpx = [px(5) px(5)+v(1) -20 0 60];
bpy = [py(5) py(5)+v(2) -10 -40 -20];
plot(bpx,bpy,'.--c','MarkerSize',15)

dx(t) = 0*t;
dy(t) = 0*t;
b(t) = 0*t;

for i = 0:n
    b(t) = nchoosek(n,i) * t^i * (1-t)^(n-i);
    dx(t) = dx(t) + bpx(i+1) * b(t);
    dy(t) = dy(t) + bpy(i+1) * b(t);
end
fplot(dx,dy,[0 1],'g')


bw = [n * (bpx(2)-bpx(1)), n * (bpy(2)-bpy(1))];
% bezier gorbe elso pontjanak erinto vektora
quiver(bpx(1),bpy(1),bw(1),bw(2),'c')




