function com = cscomb(n,x)
% CSCOMB Combination: n choose r
%   
%   COM = CSCOMB(N,R) Returns the number of combinations of N things
%   taken R at a time.

%   W. L. and A. R. Martinez, 9/15/01
%   Computational Statistics Toolbox 

% Both n and x must be positive integers.
if n <= 0
    error('N must be a positive integer.')
end
if x <= 0
    error('R must be a positive integer.')
end
if floor(n) ~= n
    error('N must be an integer.')
end
if floor(x) ~= x
    error('R must be an integer.')
end

df = n-x;
tmp = max([df,x])+1;
num = prod(n:-1:tmp) ;
den = prod(2:min([df, x]));
com = num/den;
