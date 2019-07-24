# LeetCode

###LeetCode everyday

1. Letter Combination of a Phone Number

2. Car Pooling
 > Build a linked list sorted by kilometers from start station, then scan the list judge if the node is out of capacity.
 
3. Design HashMap
 > An ugly designed hash map, using a linked list with head and tail node. Will change size dynamically when call put
   or remove method. Need to improve. Can use a node array to refactor it just like the source code in `HashMap`. Initialize
   an array of fixed size. And when call `put` method and can extend it when size is limited (when extend, re-calculate the
   hash code and put them to the new bigger array).