function [blo,bhi,bvals,zvals] = csbootint(data,fname,B,alpha)
% CSBOOTINT Boostrap-t confidence interval.
%
%	[BLO,BHI,BVALS,ZVALS] = CSBOOTINT(X,FNAME,B,ALPHA)
%
%	This function determines the bootstrap-t interval
%	for a statistic given by FNAME. The output from this function
%	is the lower and upper endpoints of a (1-ALPHA)*100% confidence
%	interval using the bootstrap percentile method.
%
%	X is an n x d array, where each row is an observation.
%	FNAME is a string for a MATLAB function that calculates a
%	statistic. The input argument to FNAME must be X only.
%	B is the number of bootstrap replicates. It is recommended that
%	this number be greater than 1000 for confidence intervals.
%	BLO and BHI are the endpoints of the interval.
%	BVALS is a vector of bootstrap replicates. 
%	ZVALS is a vector of the corresponding Z values.
%
%	See also CSBOOT, CSBOOTINT, CSBOOTBCA
%
%	Example: 	x = randn(50,1);
%				[blo,bhi,bvals,zvals] = csbootint(x,'mean',1000);
%				[blo,bhi,bvals,zvals] = csbootint(x,'myfun',1000);

%   W. L. and A. R. Martinez, 9/15/01
%   Computational Statistics Toolbox


if alpha >= 0.5
	error('Alpha must be less than 0.5')
end
[n,d] = size(data);
if d > n
	error('Each row of the data array must correspond to an observation.')
end

thetahat=feval(fname,data)
[bh,se,bt]=csboot(data,fname,50);
bvals = zeros(B,1);
zvals = bvals;
sehat = zvals;
% Loop over each resample and calculate the bootstrap replicates
for i = 1:B
   % generate the indices for the B bootstrap resamples, sampling with
   % replacement using the discrete uniform distribution.
   ind = ceil(n.*rand(n,1));
   % extract the sample from the data 
   % each row corresponds to a bootstrap resample
   xstar = data(ind,:);
   % use feval to evaluate the estimate for the i-th resample
   bvals(i) = feval(fname, xstar);
   [bh,sehat(i),bt]=csboot(xstar,fname,25);
end
zvals = (bvals - thetahat)./sehat;
% Assumes alpha < 0.5 and uses convention in Efron & Tibshirani, 1993, pg. 160
k = floor(((B+1)*alpha/2));
szval = sort(zvals);
tlo = szval(k);
thi = szval(B+1-k);
blo = thetahat-thi*se;
bhi = thetahat-tlo*se;

