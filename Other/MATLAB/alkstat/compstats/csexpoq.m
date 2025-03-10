function x = csexpoq(prob,lambda)
% CSEXPOQ Inverse exponential cumulative distribution function.
%
%   X = CSEXPOQ(PROB,LAMBDA) Returns the value of the inverse
%   exponential cumulative distribution function with parameter
%   LAMBDA for values given in PROB. 
%
%   Note that this is also called the quantiles of the
%   exponential distribution.
%
%   The exponential probability density function is 
%   given by f(x) = lambda*exp(-lambda*x).
%
%   See also CSEXPOP, CSEXPOC, CSEXPAR, CSEXPRND, CSEXPOPLOT

%   W. L. and A. R. Martinez, 9/15/01
%   Computational Statistics Toolbox 


if lambda <= 0
   error('Lambda must be greater than zero')
   return
end

if ~isempty(find(prob<0 | prob >1))
   error('Probabilities must be between 0 and 1')
   return
end

x=-1/lambda*log(1-prob);
