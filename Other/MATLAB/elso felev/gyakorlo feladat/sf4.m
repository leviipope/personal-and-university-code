clear

syms x y z

a(x,y,z) = x+y-z;
b(x,y,z) = x-2*y+3*z-4;
c(x,y,z) = 2*x-0.5*y+4*z + 2;

fimplicit3(a, "r")
hold on;
axis equal;
fimplicit3(b, "g")
fimplicit3(c, "b")