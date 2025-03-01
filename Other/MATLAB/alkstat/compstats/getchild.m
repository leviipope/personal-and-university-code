% function [done,newchild] = getchild(child,tree)
%
% this function will get all of the children of a given level of the tree
% child is a vector of nodes at a level of the tree
% tree is the tree structure
% done is a flag that will tell if all of the nodes in the level are
% terminal. done=1 means all nodes are terminal

function [done, newchild] = getchild(child,tree)
% child is a vector of current nodes at a tree level
n=length(child);
newchild=zeros(n,2);
for i=1:n
   if tree.node(child(i)).term == 0;	% if it is not a terminal node
      newchild(i,:)=tree.node(child(i)).children;
   end
end

newchild = newchild(:);
% clean out the zero nodes
ind = find(newchild==0);
if ~isempty(ind)
   newchild(ind) = [];
end
[term,nt,imp]=getdata(tree);
tp=term(newchild);	% get the terminal flags for the newchildren
if  all(tp)	% if all are 1 = terminal
   done = 1;
else
   done = 0;
end
