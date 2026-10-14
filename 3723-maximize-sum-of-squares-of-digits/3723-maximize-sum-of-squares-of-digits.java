class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num)
            return "";
        StringBuilder sb = new StringBuilder();
        while (num > 0 && sum > 0) {
            if (sum > 9) {
                sb.append(9);
                sum -= 9;
            } else {
                sb.append(sum);
                sum = 0;
            }
            num--;
        }
        while (num > 0) {
            sb.append(0);
            num--;
        }
        return sb.toString();
    }
}