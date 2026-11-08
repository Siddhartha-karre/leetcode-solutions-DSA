class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n], count=new int[101];

        for(int i=0; i<n; i++){
            if(count[nums[i]]!=0){
                ans[i]=count[nums[i]];
                continue;
            }
            int less=0;
            for(int num: nums){
                if(num<nums[i]) less++;
            }
            ans[i]=less;
            count[nums[i]]=less;
        }
        return ans;
    }
}