# LeetCode

### LeetCode everyday

1. [Letter Combination of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

2. [Car Pooling](https://leetcode.com/problems/car-pooling/)
 > Build a linked list sorted by kilometers from start station, then scan the list judge if the node is out of capacity.
 
3. [Design HashMap](https://leetcode.com/problems/design-hashmap/)
 > An ugly designed hash map, using a linked list with head and tail node. Will change size dynamically when call put
   or remove method. Need to improve. Can use a node array to refactor it just like the source code in `HashMap`. Initialize
   an array of fixed size. And when call `put` method and can extend it when size is limited (when extend, re-calculate the
   hash code and put them to the new bigger array).
   
4. [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)
 > Given two kinds of solution, first is using a `heap` to find all paths, this way is complicated, but you can review the 
   knowledge of `heap` . The other solution is using `recursive`, the codes is simple and easy to understand.

5. [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)
 > The first solution is combine two sorted arrays to one sorted array, and then can find median easily, but the time and 
   space complexity is O(m+n).
    
 > The Second solution time complexity is O(min(m, n)), and a little hard to understand. It likes a binary search. 

6. [Grid Illumination](https://leetcode.com/problems/grid-illumination/)
 > The first solution is using a 2-dimension array to store the grid, and update it when get result from queries. But it
   is memory limit exceeded when submit.
 > The second solution do not need to store the grid array, just to justify the `(x, y)` is lit or not. Init 4 map to store
   the lamps location info. lampsX for same x lamps' number, lampsY for same y lamps' number, and lampsXDiagonal/lampsYDiagonal for same 
   diagonal lamps' number. For each query just justify if the value get from 4 maps is 0 or not and then update the four maps.

 > The second solution still have time limit exceeded when the grid dimension is up to 1,000,000,000. So it is have much
   to improve

7. [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)
 > An easy problem. Need to find the maximum average contiguous subarray of given length. And what I need to do is to traverse
   the array in order and store the sum max k-length subarray `maxTotal` and the sum of current k-length subarray 
   `currentSum + nums[i] - nums[i-k]`.

8. [Set Mismatch](https://leetcode.com/problems/set-mismatch/)
 > Just need to traverse the array to find the duplicate number. And then using the correct sum and the current sum to find
   the difference between duplicate and missing number.

9. [Total Hamming Distance](https://leetcode.com/problems/total-hamming-distance/)
 > First solution is an ugly solution. I just traverse the array twice and get the hamming distance of each pair of numbers.
 > and then get the sum. So time complexity is O(n^2). It is time limit exceeded when run in LeetCode.
 > Second solution is using another thought. I do not calculate the pair or numbers' hamming distance. In contrast, I calculate
 > all numbers hamming distance for each of their bit. For an array with all numbers are 1-bit, so it contains only 0 and 1.
 > For this array the total hamming distance is easy to calculate, cause the hamming distance of 0 and 0 or 1 and 1 is 0, 
 > and 1 and 0 is 1. So the total hamming distance for this array is number of 0 multiply number of 1. Now we get 1 bit of
 > the initial array's hamming distance, so we can then repeat it 32 times to get the total hamming distance.

10. [Reverse Bits](https://leetcode.com/problems/reverse-bits/)

11. [Combination Sum](https://leetcode.com/problems/combination-sum/)
 > Using recursion to solve the problem.

12. [Reverse Words In A String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)
 > Split the original string by " " and the reverse each word.

13. [Circular Array Loop](https://leetcode.com/problems/circular-array-loop/)
 > As a circular array loop, it cannot contain both negative and positive numbers within the numbers in the loop. And if
 > the number has been used in previous non-loop it will not be in the loop if there exist a loop in the array. I traverse
 > the initial array from start to end. And for each `i`, I will try to find a loop.I create a int array to record the 
 > index that has been used before, and create a list to record the index of the loop. Using `getNextIndex()` to get 
 > `nextIndex`. There exists a loop only if the list contains the `nextIndex` and it is not the last one in the list. And
 > if `nums[nextIndex}` and `nums[currentIndex]` are not both negative or positive, or the `nextIndex` is the last one of
 > the list, it is invalid, just clear the list and break. 

14. [Valid Permutations for DI Sequence](https://leetcode.com/problems/valid-permutations-for-di-sequence/)
 > TODO

15. Simple Interpreter
 > To implement the simplest interpreter and only need to concern about the integer addition. I use structure 
 > `ExpressionNode` to store the un-calculated expression and the variable name, and use two map `variablePool`, 
 > `certainVariable` to store the un-calculated variables and calculated variables. In each expression I will try to 
 > calculate the value of the variable. If it is calculated I will store it into `certainVariable` and re-calculate
 > variables, which expression contains variable that just calculated, in `ExpressionNode`, if it is calculated in 
 > `ExpressionNode` I will remove it.

16. VerifyPreorderSerializationOfABinaryTree
  > 1. Using stack 
  > 2. *Nice Solution* Using edge, each not empty node can produce two edges and each node will cosume one edge.
  ![](https://tva1.sinaimg.cn/large/006tNbRwgy1gaql8d80p4j30wm0gc76f.jpg)
