clear

syms x y 

z(x,y) = sin(x)+(cos(y)/x);
fsurf(z, [0.1 5 -6 6])
xlabel('x');ylabel('y');zlabel('z');
grid on; box off; axis equal; hold on;

fimplicit(z, [0.1 5 -6 6] ,'r','LineWidth',5)