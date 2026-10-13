class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD=1_000_000_007;
        int[] bitCount= new int[32];
        
        for(int num: nums){
            for(int i=0; i<32; i++){
                if(((num>>i)&1)==1) bitCount[i]+=1;
            }
        }

        long res=0L;
        for(int i=0; i<k; i++){
            long num=0;
            for(int bit=0; bit<32; bit++){
                if(bitCount[bit]>0){
                    num|=(1<<bit);
                    bitCount[bit]-=1;
                }
            }
            res=(res+ (num*num)%MOD)%MOD;
        }
        return (int)res;
    }
}