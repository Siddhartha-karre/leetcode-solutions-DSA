class Solution {
    private void dfs(int index, int balance, int leftRem, int rightRem, String s, StringBuilder curr, Set<String> ans) {
        if (index == s.length()) {
            if (balance == 0 && leftRem == 0 && rightRem == 0){
                ans.add(new String(curr));
            }
            return;
        }
        char c=s.charAt(index);
        if (balance == 0 && c == ')') {
            if(rightRem>0)
            dfs(index + 1, balance, leftRem, rightRem - 1, s, curr, ans);
            return;
        }
        if(c=='(' && leftRem>0){
            dfs(index+1, balance, leftRem-1, rightRem, s, curr, ans);
        }
        else if(c==')' && rightRem>0){
            dfs(index+1, balance, leftRem, rightRem-1, s, curr, ans);
        }
        int nb=balance+(c=='('?1:c==')'?-1: 0);
        curr.append(c);
        dfs(index+1, nb, leftRem, rightRem, s, curr, ans);
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
        Set<String> ans = new HashSet<>();
        dfs(0, 0, balance, rightRem, s, curr, ans);
        return new ArrayList<>(ans);
    }
}