clear
hold on; axis equal; grid on; box off;
syms x y

z(x,y) = sin(x) + (cos(y)/x);

fsurf(z,[0.1 5 -6 6])

fimplicit(z,[0.1 5 -6 6],'r','LineWidth',3)