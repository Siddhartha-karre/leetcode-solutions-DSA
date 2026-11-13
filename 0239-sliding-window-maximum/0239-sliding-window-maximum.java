class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> maxEle = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(!maxEle.isEmpty() && maxEle.peekFirst()<=i-k) maxEle.pollFirst();

            while(!maxEle.isEmpty() && nums[maxEle.peekLast()]<nums[i]) maxEle.pollLast();
            maxEle.offerLast(i);

            if(i>=k-1){
                res[i-k+1]=nums[maxEle.peekFirst()];
            }
        }
        return res;
    }
}