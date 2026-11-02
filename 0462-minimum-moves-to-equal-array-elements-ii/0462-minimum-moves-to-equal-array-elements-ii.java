class Solution {
    public int minMoves2(int[] nums) {
        int median=0, n=nums.length, result=0;
        Arrays.sort(nums);
        median=nums[n/2];
        for(int num: nums){
            result+=Math.abs(num-median);
        }
        return result;
    }
}