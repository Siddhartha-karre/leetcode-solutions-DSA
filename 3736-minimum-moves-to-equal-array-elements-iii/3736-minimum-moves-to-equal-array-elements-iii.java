class Solution {
    public int minMoves(int[] nums) {
        int max=0, result=0;
        for(int num: nums) if(num>max) max=num;
        for(int num: nums) result+=max-num;
        return result;
    }
}