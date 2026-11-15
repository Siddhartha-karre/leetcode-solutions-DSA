class Solution {
    public int numOfSubarrays(int[] arr) {
        int count = 0, n = arr.length;
        int MOD = 1000000007;
        int odd = 0, even = 0;
        if (arr[0] % 2 == 1) {
            odd++;
            count++;
        } else
            even++;

        int prefixSum = arr[0];

        for (int i = 1; i < n; i++) {
            prefixSum += arr[i];
            if(prefixSum%2==0){
                count = (count + odd)%MOD;
                even++;
            }else{
                count = (count + even+1)%MOD;
                odd++;
            }
        }
        return count;
    }
}