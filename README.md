# LeetCode

### LeetCode everyday

1. Letter Combination of a Phone Number

2. Car Pooling
 > Build a linked list sorted by kilometers from start station, then scan the list judge if the node is out of capacity.
 
3. Design HashMap
 > An ugly designed hash map, using a linked list with head and tail node. Will change size dynamically when call put
   or remove method. Need to improve. Can use a node array to refactor it just like the source code in `HashMap`. Initialize
   an array of fixed size. And when call `put` method and can extend it when size is limited (when extend, re-calculate the
   hash code and put them to the new bigger array).
   
4. Binary Tree Paths
 > Given two kinds of solution, first is using a `heap` to find all paths, this way is complicated, but you can review the 
   knowledge of `heap` . The other solution is using `recursive`, the codes is simple and easy to understand.

5. Median of Two Sorted Arrays
 > The first solution is combine two sorted arrays to one sorted array, and then can find median easily, but the time and 
   space complexity is O(m+n).
    
 > The Second solution time complexity is O(min(m, n)), and a little hard to understand. It likes a binary search. 

6. Grid Illumination
 > The first solution is using a 2-dimension array to store the grid, and update it when get result from queries. But it
   is memory limit exceeded when submit.
 > The second solution do not need to store the grid array, just to justify the `(x, y)` is lit or not. Init 4 map to store
   the lamps location info. lampsX for same x lamps' number, lampsY for same y lamps' number, and lampsXDiagonal/lampsYDiagonal for same 
   diagonal lamps' number. For each query just justify if the value get from 4 maps is 0 or not and then update the four maps.

 > The second solution still have time limit exceeded when the grid dimension is up to 1,000,000,000. So it is have much
   to improve

7. Maximum Average Subarray I
 > An easy problem. Need to find the maximum average contiguous subarray of given length. And what I need to do is to traverse
   the array in order and store the sum max k-length subarray `maxTotal` and the sum of current k-length subarray 
   `currentSum + nums[i] - nums[i-k]`.