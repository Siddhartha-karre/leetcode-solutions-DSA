class Solution {
    public int reverseDegree(String s) {
        int result=0, n=s.length();
        for(int i =0; i<n; i++){
            result+=(i+1)*(26-(s.charAt(i)-97));
        }
        return result;
    }
}