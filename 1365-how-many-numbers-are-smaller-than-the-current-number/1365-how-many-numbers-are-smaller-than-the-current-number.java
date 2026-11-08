class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];

        for(int i=0; i<n; i++){
            
            int less=0;
            for(int num: nums){
                if(num<nums[i]) less++;
            }
            ans[i]=less;
        }
        return ans;
    }
}