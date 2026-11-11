class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(need1==0 && need2==0) return 0;
        long total=0L;
        long minNeed=Math.min(need1, need2);
        long c1=cost1, c2=cost2, cb=costBoth, n1=need1, n2=need2;
        total+=Math.min(c1+c2, cb)*minNeed;
        if(n1>minNeed){
            total+=Math.min(cb, c1)*(n1-minNeed);
        }
        if(n2>minNeed){
            total+=Math.min(cb, c2)*(n2-minNeed);
        }
        return total;
    }
}