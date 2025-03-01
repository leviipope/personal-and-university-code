
function tree = addnoder(tree,snode,sdim,sval)

% snode is the node number/index that will be split
% sdim is the dimension that will be split on
% sval is the value determining the split
%
% this function will add the left and right nodes based on the new split

% get the new node numbers - total number of nodes
nleft = tree.numnodes +1;
nright = tree.numnodes +2;
tree.numnodes = nright;  	% reset the number of nodes in the tree

% reset things on the parent node
tree.node(snode).term = 0;	% no longer a terminal node
tree.node(snode).children = [nleft nright];
tree.node(snode).split = sval;
tree.node(snode).var = sdim;

% set the easy things
tree.node(nleft).term=1;	% it is a terminal node
tree.node(nright).term=1;
tree.node(nleft).parent = snode;	% the parent is the node number we are splitting
tree.node(nright).parent = snode;
tree.node(nleft).children = [];		% it has no children.
tree.node(nright).children = [];
tree.node(nleft).sibling = nright;
tree.node(nright).sibling = nleft;
tree.node(nleft).split = [];	% no split - terminal node
tree.node(nright).split = [];
tree.node(nleft).var = [];		% no split
tree.node(nright).var = [];


% find the amount of data in the left node
x = tree.node(snode).x;	% these are the data that will be split
y = tree.node(snode).y;
[n,dd]=size(x);
ind = find(x(:,sdim)<=sval);
indr = find(x(:,sdim)>sval);
tree.node(nleft).nt = length(ind);	% number of points in the node
tree.node(nright).nt = length(indr);
tree.node(nleft).x=x(ind,:);
tree.node(nright).x=x(indr,:);
tree.node(nleft).y = y(ind);
tree.node(nright).y = y(indr);
tree.node(nleft).yhat = mean(y(ind));
tree.node(nright).yhat = mean(y(indr));
tree.node(nleft).impurity = sqrer(tree.node(nleft).y,tree.n);
tree.node(nright).impurity = sqrer(tree.node(nright).y,tree.n);
%keyboard
