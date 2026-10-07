class Solution {
    private void dfs(int index, int balance, int leftRem, int rightRem, boolean prevRemoved, String s, StringBuilder curr, List<String> ans) {
        if (index == s.length()) {
            if (balance == 0 && leftRem == 0 && rightRem == 0){
                ans.add(new String(curr));
            }
            return;
        }
        char c=s.charAt(index);
        if(c!='(' && c!=')'){
            curr.append(c);
            dfs(index+1, balance, leftRem, rightRem, false, s, curr, ans);
            curr.setLength(curr.length()-1);
            return;
        }

        if (balance == 0 && c == ')') {
            if(rightRem>0 &&(index==0 || s.charAt(index-1)!=c || prevRemoved))
            dfs(index + 1, balance, leftRem, rightRem - 1, true, s, curr, ans);
            return;
        }
        if(c=='(' && leftRem>0){
            if(index==0 || s.charAt(index-1)!=c || prevRemoved)
            dfs(index+1, balance, leftRem-1, rightRem, true, s, curr, ans);
        }
        else if(c==')' && rightRem>0){
            if(index==0 || s.charAt(index-1)!=c || prevRemoved)
            dfs(index+1, balance, leftRem, rightRem-1, true, s, curr, ans);
        }
        int nb=balance+(c=='('? 1 : -1);
        curr.append(c);
        dfs(index+1, nb, leftRem, rightRem, false, s, curr, ans);
        curr.deleteCharAt(curr.length()-1);
    }

    public List<String> removeInvalidParentheses(String s) {
        int balance=0, rightRem=0;
        for(char ch: s.toCharArray()){
            if(ch=='(') balance++;
            else if(ch==')'){
                balance--;
                if(balance<0){
                    balance=0; rightRem++;
                }
            }
        }
        StringBuilder curr = new StringBuilder();
        List<String> ans = new ArrayList<>();
        dfs(0, 0, balance, rightRem, false, s, curr, ans);
        return ans;
    }
}