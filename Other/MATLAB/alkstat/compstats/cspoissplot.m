function cspoissplot(k, n_k)
% CSPOISSPLOT Construct a Poissonness plot.
%
%   CSPOISSPLOT(K, NK) Constructs a Poissonness plot, which
%   is used to graphically determine whether the observed
%   counts follow a Poisson distribution. The inputs to the
%   function are a vector of counts K and the frequency of
%   occurrence NK.
%
%   See also CSPOISP, CSPOISC, CSPOIRND, CSPOIPAR, CSBINOPLOT


%   W. L. and A. R. Martinez, 9/15/01
%   Computational Statistics Toolbox 

% poissoness plot - basic
N=sum(n_k);
% get vector of factorials
fact=zeros(size(k));
for i=k
   fact(i+1)=factorial(i);
end
% get phi(n_k) for plotting
phik=log(fact.*n_k/N);
% find the counts that are equal to 1
% plot these with the symbol 1
% plot rest with a symbol
ind=find(n_k~=1);
plot(k(ind),phik(ind),'o')
ind=find(n_k==1);
if ~isempty(ind)
   text(k(ind),phik(ind),'1')
end
% add some whitespace to see better
axis([-0.5 max(k)+1 min(phik)-1 max(phik)+1])
xlabel('Number of Occurrences - k')
ylabel('\phi (n_k)')
