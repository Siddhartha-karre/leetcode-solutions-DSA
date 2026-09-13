class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        HashMap<String, Integer> freq = new HashMap<>();
        int max=0;
        List<int[]> ones1= new ArrayList<>();
        List<int[]> ones2= new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(img1[i][j]==1) ones1.add(new int[]{i,j});
                if(img2[i][j]==1) ones2.add(new int[]{i,j});
            }
        }
        for(int[] a: ones1){
            for(int[] b: ones2){
                String key = (b[0]-a[0])+","+(b[1]-a[1]);
                int count = freq.getOrDefault(key, 0)+1;
                freq.put(key, count);
                max=Math.max(count, max);
            }
        }
        
        return max;
    }
}