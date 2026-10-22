class Solution {
    public int minOperations(int[] nums) {
        int incDrops=0, decDrops=0, n=nums.length;

        for(int i=0; i<n; i++){
            if(nums[i]<nums[(i+1)%n]) decDrops++;
            if(nums[i]>nums[(i+1)%n]) incDrops++;
        }
        if(incDrops>1 && decDrops>1) return -1;
  
        if(incDrops<=1){
            int i;
            for(i=0; i<n; i++){
                if(nums[i]==0) break;
            }
            return Math.min(i, 2+n-i);
        }
        if(decDrops==0) return 0;
        int z;
        for(z=0; z<n; z++){
            if(nums[z]==0) break;
        }
        int optA=(z+2);
        int optB=1+(n-z-1);
        return Math.min(optA, optB);

    }
}