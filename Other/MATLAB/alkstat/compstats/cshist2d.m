function [XX,YY,Z] = cshist2d(x,flag,h)
% CSHIST2D  Bivariate histogram.
%
%   [X,Y,Z] = CSHIST2D(DATA,FLAG,H)
%
%   Constructs a bivariate histogram using the observed DATA. Each row
%   of DATA corresponds to a bivariate observation. 
%   H is the smoothing parameter. This is optional. The default is the 
%   Normal Reference Rule bin width.
%   FLAG indicates what type of plot to provide: 1 = SURF,2 = Square bins
%   
%   X and Y provide the coordinates of the bins. Z is the height of the
%   histogram.
%
%   See also CSHISTDEN, CSFREQPOLY, CSASH

%   W. L. and A. R. Martinez, 9/15/01
%   Computational Statistics Toolbox

[n,p] = size(x);
if p ~= 2
    error('Must be bivariate data.')
end

if nargin == 2
    % then get the default bin width
    covm = cov(x);
    h(1) = 3.5*covm(1,1)*n^(-1/4);
    h(2) = 3.5*covm(2,2)*n^(-1/4);
else
    if length(h)~=2
        error('Must have two bin widths in h.')
    end
end

% Need bin origins.
bin0=[floor(min(x(:,1))) floor(min(x(:,2)))]; 
% find the number of bins
nb1 = ceil((max(x(:,1))-bin0(1))/h(1));
nb2 = ceil((max(x(:,2))-bin0(2))/h(2));
% find the mesh
t1 = bin0(1):h(1):(nb1*h(1)+bin0(1));
t2 = bin0(2):h(2):(nb2*h(2)+bin0(2));
[X,Y] = meshgrid(t1,t2);
% Find bin frequencies.
[nr,nc] = size(X);
vu = zeros(nr-1,nc-1);
for i = 1:(nr-1)
   for j = 1:(nc-1)
      xv = [X(i,j) X(i,j+1) X(i+1,j+1) X(i+1,j)];
      yv = [Y(i,j) Y(i,j+1) Y(i+1,j+1) Y(i+1,j)];
      in = inpolygon(x(:,1),x(:,2),xv,yv);
      vu(i,j) = sum(in(:));
   end
end
Z = vu/(n*h(1)*h(2));
% Get some axes that make sense.
[XX,YY]=meshgrid(linspace(-3,3,nb1),...
				linspace(-3,3,nb2));
      
if flag == 1
    surf(XX,YY,Z)
    grid off
    axis tight
elseif flag == 2
    % The Z matrix is obtained in Example 5.14
    bar3(Z,1)
    % Use some Handle Graphics.
    set(gca,'YTickLabel',' ','XTickLabel',' ')
    set(gca,'YTick',0,'XTick',0)
    grid off
    axis tight
else
    error('Flag must be 1 for surface plot or 2 for square bins.')
end


