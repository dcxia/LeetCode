package EasyProblems;

import LeetCodeDS.TreeNode;
import java.util.*;
/*
    ###########################################
           List of Problems
    ###########################################
    From here out, problems will be done in
    their own classes.

    ###########################################
       1.    Two Sum                 1
       2.    Hamming Distance        461
       3.    Merge Two Binary Trees  617
       4.    Single Number           136
       5.    Move Zeroes             283
 */



public class EasyProblems {

    /*
    ################################################################################
    1. TWO SUM
    URL: https://leetcode.com/problems/two-sum/description/

    DESCRIPTION: Given an array of integers, return indices of the two numbers
    such that they add up to a specific target. You may assume that
    each input would have exactly one solution, and you may not use the
    same element twice.

    EXAMPLE:
        In:    nums = [2, 7, 11, 15], target = 9,
        Out:   [0, 1].

    SOLUTION:
    This solution does 2 passes.
    The first pass is to put all the values into a hash table as <value,index> pair.
    Keep in mind that values can be repeated and as such, only the key with the
    largest index will stay.

    The second pass is to find the complement of the target, 'num2' to see if
    the complement exists in the hash table for each value in the array, 'num1'. If the
    complement exists and it does not exist in the same index as 'num1', than the
    sum of the two values at the index must be the target

    ################################################################################
    */

    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();

        for (int i =0; i< nums.length; i++){
            hash.put(nums[i], i);
        }

        for (int i =0; i < nums.length; i++) {
            int num2 = target - nums[i];
            if (hash.containsKey(num2) && (hash.get(num2) != i)) {
                return new int[] {i, hash.get(num2)};
            }
        }
        return null;
    }

    /*
    ################################################################################
    461. HAMMING DISTANCE
    URL: https://leetcode.com/problems/hamming-distance/description/

    DESCRIPTION: The Hamming distance between two integers is the number of
    positions at which the corresponding bits are different. Given two integers x
    and y, calculate the Hamming distance.

    EXAMPLE:
        In:    X = 1, Y = 4
        Out:   2
        Explanation:    1   (0 0 0 1)
                        4   (0 1 0 0)
                               ^   ^
    SOLUTION:
    There's no need to save the binary values of the numbers. Instead,the remainder
    (binary value) can be checked using mod and  the numbers can be halved since the
    integers round down.


    You can also use a bitwise function to transform x and y into a new number z
    using the bitwise xor command. This creates a number where the binary
    representation is a combination of x and y except it marks the bits that are
    different from each other as 1 and the same as 0. This creates a number
    that represents the non similar bits.
    ###############################################################################
    */
    public int hammingDistance(int x, int y){
        /*
        //Solution 1
        int counter = 0;

        while (x!= 0 || y != 0){
            if (x % 2 != y % 2){
                counter++;
            }
            x = x/2;
            y = y/2;
        }
        return counter;
        */
        int counter = 0;
        var z = x^y;    //Bit wise comparison xor

        while (z!=0){
            if (z%2 != 0){
                counter++;
            }
            z = z/2;
        }
        return counter;
    }

   /*
    ################################################################################
    617. MERGE TWO BINARY TREES
    https://leetcode.com/problems/merge-two-binary-trees/description/

    DESCRIPTION: Given two binary trees and imagine that when you put one of them to
    cover the other, some nodes of the two trees are overlapped while the others are
    not.

    You need to merge them into a new binary tree. The merge rule is that if two
    nodes overlap, then sum node values up as the new value of the merged node.
    Otherwise, the NOT null node will be used as the node of new tree.

    EXAMPLE:
        Input:

	    Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7

        Output:

    Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7

    SOLUTION:
    REMEMBER YOU CAN USE NULL OBJECTS AS PARAMETERS!
    This code works by going through the binary trees recursively. It also works by
    mainpulating one of the trees that are used as a parameter. Remember to look at
    the problem based on the implied functionality of the solution (merges two
    binary trees).
    ###############################################################################
    */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
         if (t1 == null){
             return t2;
         }
         if (t2 == null){
             return t1;
         }
         t1.val += t2.val;
         t1.left = mergeTrees(t1.left, t2.left);
         t1.right = mergeTrees(t1.right, t2.right);

         return t1;
     }




    /* 136. Single Number
    ################################################################################
    https://leetcode.com/problems/single-number/

    DESCRIPTION: Given a non-empty array of integers, every element appears twice
    except for one. Find that single one.

    Note: Your algorithm should have a linear runtime complexity. Could you
    implement it without using extra memory?

    eg)
    Input: [2,2,1]
    Output: 1

    Input: [4,1,2,1,2]
    Output: 4

    SOLUTION: This problem is of linear run time complexity, no embedded for loops!

    solution 1: HashMap
    One way of solving this problem is to use a hash table to store whether or not
    a number has been seen before. When you come across a number you can mark it as
    true (seen) and if you come across the number again, you can mark it as false
    (seen again). After iterating through all the numbers, you can check the values
    of the array through the map until you come across the single number that comes
    back as true. The problem with this solution is that it does use extra memory.

   solution 2: Math
   Get all unique elements of array using set method on array. Multiply the sum of
   the array

    ################################################################################
   */

    //HashTable solution
    public int singleNumber(int[] nums){
         Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();

         for (int i =0; i< nums.length; i++){
             if (map.containsKey(nums[i])){
                 map.replace(nums[i],false);
             }else{
                 map.put(nums[i],true);
             }
         }

         for (int i = 0; i < nums.length; i++){
             if (map.get(nums[i])){
                 return nums[i];
             }

         }
         return 0;

     }

    // Arithmetic approach
    public int singleNumber1(int[] nums){
        ArrayList<Integer> list = new ArrayList();
        for(int i: nums){
            if (!list.contains(i)){
                list.add(i);
            }
        }
        int totalSum = 0;
        for(int i= 0; i < list.size();i++){
            totalSum += list.get(i);
        }
        totalSum *=2;

        for(int i: nums){
           totalSum -= i;
        }
    return totalSum;
    }

    /* 283. Move Zeroes
   ################################################################################
   https://leetcode.com/problems/move-zeroes/

   DESCRIPTION: Given an Array nums, write a function to move all 0's to the end of
   it while maintaining the relative order of the non-zero elements.

   Note:
   1. You must do this in-place without making a copy of the array.
   2. Minimize the total number of operations

   eg)
   Input: [0,1,0,3,12]
   Output: [1,3,12,0,0]


   SOLUTION: Iterate through the array until you find a zero element. Save the
   position of this element. Iterate through the array again until you find a non
   zero element. If the index of the zero element is smaller than the index of the
   non zero element, swap the positions of these two numbers and stop looking
   for a non zero element. Continue iterating through looking for a zero element
   until you find one.

   The algorithm returns an array with all the zero elements pushed to the right
   of the array while maintaining the order of the non zero elements.

   ################################################################################
  */
    public void moveZeroes(int[] nums) {
        int marker1 = 0;
        int marker2 = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                marker1 = i;
                for (int j = marker2; j <nums.length;j++){
                    if ((nums[j]!= 0) && i < j){
                        marker2 = j;
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }

        }
    }


}
