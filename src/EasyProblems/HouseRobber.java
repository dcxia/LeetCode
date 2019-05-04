package EasyProblems;
import java.lang.Math.*;
public class HouseRobber {


    /*
    LESSON LEARNED FROM THIS PROBLEM:
    FIGURE OUT END CASES FOR RECURSIVE PROBLEMS AND WORK BACKWARDS

    I've been having a lot of issues with this problem, specifically building the recursion cases and imagining how I'm
    supposed to traverse the array.

    As a result I've found a helpful tip for working on these recursive problems. Here is the link

    https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.

    For most recursive problems, we need to remember that these only work from the end to the start (since the end case
    of the input is what tells us to return)

    Therefore, the robber is always in one of two states

    1. Rob this house, but get the value of all houses at least 1 away  [ value = rob(i - 2) + thisHouseValue]
    2. Dont rob this house, but get the value of all houses before this house [ value = rob(i-1)]

    We're trying to find the max of these two states once we're at the end of the array. So we can summarize this
    problem as

    rob(i) = Math.max(rob(i - 2) + nums[i], rob(i-1))

     */
    public static int rob(int[]nums){
        return rob(nums,nums.length -1);
    }

    public static int rob(int[]nums, int index){
        if (index < 0){
            return 0;
        }
        return (Math.max(rob(nums,index-2) + nums[index],rob(nums,index-1)));
    }

    public static void main(String[] args){
        //Should be 13
        int[] nums = new int[]{6,4,3,7,2};
        System.out.println(rob(nums));
    }
}
