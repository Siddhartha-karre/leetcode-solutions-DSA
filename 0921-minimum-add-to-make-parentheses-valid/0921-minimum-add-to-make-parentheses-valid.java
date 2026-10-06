class Solution {
    public int minAddToMakeValid(String s) {
        int cnt=0, add=0;
        for(char ch: s.toCharArray()){
            if(ch=='(') cnt++;
            else cnt--;
            if(cnt<0){
                add++;
                cnt=0;
            }
        }
        add+=cnt;
        return add;
    }
}