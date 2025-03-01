function [bhat,sehat,bvals] = csboot(data,fname,B)
% CSBOOT Bootstrap method
%
%	[BHAT,SEHAT,BVALS] = CSBOOT(X,FNAME,B)
%
%	This function will return the bootstrap distribution
% 	for a statistic given by FNAME. 
%
%	The matrix X is an n x d array, where each row contains an
%	observation.
%	B is the number of bootstrap replicates. For estimates of the
%	standard error, this should be betwwen 50 and 200. For estimates
%	of the bias, B should be greater than 400.
%	FNAME is a string for a MATLAB function that calculates a
%	statistic. The input argument to FNAME must be X only.
%	BHAT is the bootstrap estimate of the bias of the statistic.
%	SEHAT is the bootstrap estimate of the standard error of the statistic.
%	BVALS is a vector of boostrap replicates of the statistic.
%
%	See also CSBOOPERINT, CSBOOTINT, CSBOOTBCA, CSJACKBOOT, CSJACK
%
%	Example: 	x = randn(50,1);
%				[bhat,sehat,bvals] = csboot(x,'mean',100);
%				[bhat,sehat,bvals] = csboot(x,'myfun',400);

%   W. L. and A. R. Martinez, 9/15/01
%   Computational Statistics Toolbox

% Check to make sure that each row of the data matrix is 
% an observation.
[n,d] = size(data);
if d > n
	error('Each row of the data array must correspond to an observation.')
end

% find observed value of statistic using original data
thetahat = feval(fname,data);
[n,d] = size(data);
bvals = zeros(B,1);
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
end
bhat = mean(bvals)-thetahat; 
sehat = sqrt(var(bvals));