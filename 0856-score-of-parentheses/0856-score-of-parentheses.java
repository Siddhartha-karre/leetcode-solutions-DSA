class Solution {
    public int scoreOfParentheses(String s) {
        int depth=0, score=0, n=s.length();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch=='(') depth++;
            else{
                depth--;
                if(s.charAt(i-1)=='('){
                    score+=1<<depth;
                }
            }
        }
        return score;
    }
}