function yhatnw = csnardwats(x,y,h)
% CSNARDWATS  Nadarya-Watson kernel estimator.
%
%   YHAT = CSNARDWATS(X,Y,H)
%   Performs nonparametric regression using the Nadarya-Watson
%   kernel estimator. The observed data are contained in X and Y.
%   The smoothing parameter is given by the kernel bandwidth H.
%   YHAT contains the values of the smooth for each value in X.
%
%   See also CSLOESS, CSLOCPOLY, CSLOCLIN

%   W. L. and A. R. Martinez, 9/15/01
%   Computational Statistics Toolbox

% Create an inline function to evaluate the weights.
mystrg='(2*pi*h^2)^(-1/2)*exp(-0.5*((x - mu)/h).^2)';
wfun = inline(mystrg);

% Set up the space to store the estimated values.
% We will get the estimate at all values of x.
yhatnw = zeros(size(x));
n = length(x);
% find smooth at each value in x
for i = 1:n
		w = wfun(h,x(i),x);
		yhatnw(i) = sum(w.*y)/sum(w);
end

