class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;

        for(int i=0; i<n; i++) if(nums[i]<0) nums[i]=-1*nums[i];

        Arrays.sort(nums);
        long score=0; 
        for(int i=0; i<n; i++){
            long x=nums[i];
            if(i<n/2) score-=x*x;
            else score+=x*x;
        }
        return score;
    }
}