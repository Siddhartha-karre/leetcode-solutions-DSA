class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int insert=0, n=s.length();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch=='(') st.push('(');
            else{
                boolean empty=st.isEmpty();
                if(i==n-1){
                    if(empty){
                        insert+=2;
                    }else{
                        insert++;
                        st.pop();
                    }
                    continue;
                }
                if(i<n-1 && s.charAt(i+1)==')'){
                    if(empty) insert++;
                    else st.pop();
                    i++;
                    continue;
                }
                if(s.charAt(i+1)!=')'){
                    if(empty) insert+=2;
                    else{
                        insert++;
                        st.pop();
                    }
                }
            }
        }
        if(!st.isEmpty()) insert+=2*st.size();
        return insert;
    }
}