class Solution {
    private int score(int low, int high, String s){
        if(low>=s.length() || high<0) return 0;
        if(low>=high) return 0;
        if(low==high-1) return 1;
        int i, cnt=0;
        for(i=low; i<=high; i++){
            if(s.charAt(i)=='(') cnt++;
            else cnt--;
            if(cnt==0) break;
        }
        if(i==high) return 2*score(low+1, high-1, s);
        return score(low, i, s) + score(i+1, high, s);
    }
    public int scoreOfParentheses(String s) {
        return score(0, s.length()-1, s);
    }
}