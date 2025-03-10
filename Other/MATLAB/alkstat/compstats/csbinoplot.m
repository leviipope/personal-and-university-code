function csbinoplot(n,k,n_k)
% CSBINOPLOT Binomialness plot.
%
%   CSBINOPLOT(N,K,NK) Constructs a binomialness plot, which
%   is used to graphically determine whether the observed
%   counts follow a binomial distribution with parameter N.
%   K is a vector of counts and the frequecny of occurrence NK.
%
%   See also CSBINOP, CSBINOC, CSBINOQ, CSBINRND, CSBINPAR, CSPOISSLOT


%   W. L. and A. R. Martinez, 9/15/01
%   Computational Statistics Toolbox 

% binomialness plot
N=sum(n_k);
nCk=zeros(size(k));
for i=k
   nCk(i+1)=cscomb(n,i);
end
% find the frequencies equal to zero - delete them
ind=find(n_k==0);
n_k(ind)=[];
k(ind)=[];
nCk(ind)=[];
phat=n_k/N;
nkstar=n_k-0.67-0.8*phat;
% find the frequencies that are 1; nkstar=1/e
ind1=find(n_k==1);
nkstar(ind1)= 1/2.718;
% get phi(n_k) for plotting
phik=log(nkstar./(N*nCk));
% find the counts that are equal to 1
% plot these with the symbol 1
% plot rest with a symbol
ind=find(n_k~=1);
plot(k(ind),phik(ind),'o')
if ~isempty(ind1)
   text(k(ind1),phik(ind1),'1')
end
% add some whitespace to see better
axis([-0.5 max(k)+1 min(phik)-1 max(phik)+1])
xlabel('Number of Occurrences - k')
ylabel('\phi (n^*_k)')
