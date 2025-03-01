clear
syms x y
f(x,y) = sin(x)+cos(y);
fsurf(f)
axis equal
xlabel('x');ylabel('y');zlabel('z');

%PONT
x0 = 5; y0 = 3;
hold on
plot3(x0,y0,f(x0,y0),'*r','MarkerSize',15)

%SIKMETSZET XY-RA
fimplicit(f,'*r','LineWidth',4)