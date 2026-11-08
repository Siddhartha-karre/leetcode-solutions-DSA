class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<Integer> ans= new ArrayList<>();
        for(int i=1; i<nums[0]; i++) ans.add(i);
        for(int i=0; i<n-1; i++){
            if(nums[i]==nums[i+1] || nums[i]==nums[i+1]-1) continue;
            else{
                for(int j=nums[i]+1; j<nums[i+1]; j++) ans.add(j);
            }
        }
        for(int i=nums[n-1]+1; i<=n; i++) ans.add(i);

        return ans;
    }
}