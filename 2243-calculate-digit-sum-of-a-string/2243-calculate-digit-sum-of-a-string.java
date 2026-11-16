class Solution {
    public String digitSum(String s, int k) {
        StringBuilder ans = new StringBuilder(s);
        int n = s.length();
        while(k<n){
            StringBuilder sb = new StringBuilder();
            int sum=0;
            for(int i=0; i<n; i++){
                sum+=ans.charAt(i)-'0';
                if((i+1)%k == 0 || i==n-1){
                    sb.append(sum);
                    sum = 0;
                }
            }
            ans = sb;
            n=sb.length();
        }
        return ans.toString();
    }
}