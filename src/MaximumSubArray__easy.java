//problem URL: https://leetcode.com/problems/maximum-subarray/
// @author:ram



 class Solution {
    public int maxSubArray(int[] nums) {

        //how to effectively choose the sub arrays
        //kadane's algorithm
        int maxsum =0;
        int maxSumSoFar = nums[0];

        for (int i =0; i< nums.length ; i ++){
            maxsum = maxsum + nums[i];
            // System.out.println("Maxsum for i= "+i+"is "+maxsum);
            if( maxSumSoFar < maxsum){
                maxSumSoFar= maxsum;
                // System.out.println("Max Sum So Far till i = "+i+" is "+maxSumSoFar);
            }
            if(maxsum< 0){
                maxsum =0;
            }
        }
        return maxSumSoFar;

    }
}
