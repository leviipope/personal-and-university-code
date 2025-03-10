cla()
clear

syms x y z

f(x,y,z) = x^2 + y^2 + z^2 -1;

fimplicit3(f, [-1,1,-1,1,-1,1])