package EasyProblems;
/* 53. Maximum Subarray

Description:
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.


Example:
Input: [-2, 1,-3,4,-1,2,1,-5,4 ]
output: 6
Explanation: [4,-1,2,1] has the largest sum = 6

Complete this in O(n) time


 */
public class MaximumSubArray {


    //BruteForce solution
    public static int solution(int[] nums){
        int max = nums[0];
        int sum = 0;
        for (int i = 0 ; i < nums.length; i++){
            sum = nums[i];
            if (nums[i] > max){
                max = nums[i];
            }
            for (int j = i+1; j < nums.length; j++){
                sum += nums[j];
                if (sum > max){
                   max = sum;
                }
            }
        }
        return max;
    }


    public static void main(String[] args){

        System.out.println(solution(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
}
