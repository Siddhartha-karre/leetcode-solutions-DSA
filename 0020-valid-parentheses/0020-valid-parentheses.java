class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                Character top = st.pop();
                if(
                    (ch==')' && top!='(') || 
                    (ch=='}' && top!='{') || 
                    (ch==']' && top!='[')
                ) return false;
            }
        }
        return st.isEmpty();
    }
}