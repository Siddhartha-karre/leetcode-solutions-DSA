class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int i=0, j=0;
        while(i<2*n-1 && j<n){
            ans[i]=nums[j];
            ans[i+1]=nums[j+n];
            i+=2;
            j++;
        }
        return ans;
    }
}