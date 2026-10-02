class Solution {
    private void generate(int n, int open, int close, Set<String> res, StringBuilder sb){
        if(open==n && close==open){
            res.add(new String(sb));
            return;
        }
        if(open<n){
            sb.append('(');
            generate(n, open+1, close, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            generate(n, open, close+1, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        generate(n, 1, 0, res, sb);
        return new ArrayList<>(res);
    }
}