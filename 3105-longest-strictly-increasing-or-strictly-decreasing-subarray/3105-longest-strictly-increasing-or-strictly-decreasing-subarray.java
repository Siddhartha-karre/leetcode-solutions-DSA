class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // case1: Strictly increasing
        int incLen =  0, low =0, high = 0, n=nums.length;
        while(high<n-1){
            if(nums[high]<nums[high+1]) high++;
            else {
                incLen=Math.max(incLen, high-low+1);
                high++;
                low=high;
            }
        }
        incLen=Math.max(incLen, high-low+1);
        // Case 2: Strictly decreasing
        low=0; high=0;
        while(high<n-1){
            if(nums[high]>nums[high+1]) high++;
            else{
                incLen=Math.max(incLen, high-low+1);
                high++;
                low=high;
            }
        }


        return incLen>high-low+1? incLen: high-low+1;
    }
}