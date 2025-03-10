function tree = cspicktreec(treeseq,k)
% CSPICKTREEC   Extract a tree from the sequence.
%
%   TREE = CSPICKTREEC(TREESEQ,K)
%   Once the 'best' tree in the sequence has been chosen, 
%   this function extracts that tree from the sequence and
%   returns it in the variables TREE. This function also
%   cleans out the field in TREE that contains the data. 
%   K is the index of the tree to extract from the sequence.
%
%   See also CSGROWC, CSTREEC, CSPRUNEC, CSPLOTREEC

%   W. L. and A. R. Martinez, 9/15/01
%   Computational Statistics Toolbox 

p = length(treeseq);
if k > p | k <= 0
    error(['In this case, k must be between 1 and ', int2str(p)])
end

% Get the tree from the sequence.
tree = treeseq{k};

% Remove the data field from the tree - not needed.
tree.node = rmfield(tree.node,'data');
