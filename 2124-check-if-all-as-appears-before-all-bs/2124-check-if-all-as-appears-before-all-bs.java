class Solution {
    public boolean checkString(String s) {
        boolean foundB = false;
        for(char ch: s.toCharArray()){
            if(ch=='a'){
                if(foundB) return false;
            }else{
                foundB=true;
            }
        }
        return true;
    }
}