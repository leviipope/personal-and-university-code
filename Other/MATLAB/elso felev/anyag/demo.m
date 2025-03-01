e=[rx(tk(5)) ry(tk(5))];
ev=[rxd(tk(5))*k ryd(tk(5))*k];
quiver(e(1),e(2),ev(1),ev(2),'c','LineWidth',3)

n = 4;

bpx = [a(5) a(5)+ev(1) 0 3 30];
bpy = [b(5) b(5)+ev(2) 0 -15 -10];
plot(bpx,bpy,'.--r')
cx(t) = 0*t;
cy(t) = 0*t;


for i = 0 : n
    b(t) = nchoosek(n,i) * t^i * (1-t)^(n-i);
    cx(t) = cx(t) + b(t) * bpx(i+1);
    cy(t) = cy(t) + b(t) * bpy(i+1);
end
fplot(cx,cy,[0 1],'c')