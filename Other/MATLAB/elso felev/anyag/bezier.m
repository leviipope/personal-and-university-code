% bezier
clear
cla()

px = [-1 6 8 1];
py = [2 7 -8 5];

% plot(px, py, ".--r", MarkerSize=15)
axis equal; hold on;


n = length(px)-1;

if length(px) < length(py)
    n = length(px)-1;
else
    n = length(py)-1;
end
syms t
b(t) = 0*t;
cx(t) = 0*t;
cy(t) = 0*t;
% megcsináljuk alapból a függvényt nullára

for i = 0:n
    b(t) = nchoosek(n,i) * t^i * (1-t)^(n-i);
    % létrehozzuk a b nevű függvényt
    
    cx(t) = cx(t) + px(i+1) * b(t);
    cy(t) = cy(t) + py(i+1) * b(t);
    % hozzáfűzzük a behelyettesített függvényt a függvényekhez
end

fplot(cx, cy, [0 1])

v0 = [n * (px(2)-px(1)), n* (py(2)-py(1))];

v1 = [n * (px(n+1)-px(n)), n* (py(n+1)-py(n))];

cxd(t) = diff(cx(t), t);
cyd(t) = diff(cy(t), t);

% fplot(cxd, cyd)

% quiver(px(1), py(1), v0(1), v0(2))
quiver(px(n+1), py(n+1), v1(1), v1(2))

%%%%%%%%%%%%%%%%% csatlakoztatás

m = 5;
rx = [px(4), px(4) + v1(1)/m, 16, -20, -4, 2];
ry = [py(4), py(4) + v1(2)/m, -8, 26, -4, 20];

% plot(rx, ry, '.--')

b(t) = 0*t;
cx(t) = 0*t;
cy(t) = 0*t;
% megcsináljuk alapból a függvényt nullára

for i = 0:m
    b(t) = nchoosek(m,i) * t^i * (1-t)^(m-i);
    % létrehozzuk a b nevű függvényt

    cx(t) = cx(t) + rx(i+1) * b(t);
    cy(t) = cy(t) + ry(i+1) * b(t);
    % hozzáfűzzük a behelyettesített függvényt a függvényekhez
end

fplot(cx, cy, [0 1])