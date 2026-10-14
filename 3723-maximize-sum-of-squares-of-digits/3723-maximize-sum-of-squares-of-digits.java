class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<sum/9; i++) sb.append(9);
        if(sum%9>0) sb.append(sum%9);
        int zeros=num-sb.length();
        for(int i=0; i<zeros; i++) sb.append(0);

        return sb.toString(); 
    }
}