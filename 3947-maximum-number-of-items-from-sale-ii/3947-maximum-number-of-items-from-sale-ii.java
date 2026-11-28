class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
        }

        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] multiplesCount = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= maxFactor; m += f) {
                multiplesCount[f] += freq[m];
            }
        }

        int[][] itemInfo = new int[n][2];
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int p = items[i][1];
            itemInfo[i][0] = p;
            itemInfo[i][1] = multiplesCount[f] - 1;
            minPrice = Math.min(minPrice, p);
        }

        Arrays.sort(itemInfo, (a, b) -> Integer.compare(a[0], b[0]));

        long totalCopies = 0;
        long remBudget = budget;

        for (int[] info : itemInfo) {
            long price = info[0];
            long gain = info[1];
            if (gain <= 0) continue;

            if (price >= 2L * minPrice) {
                break;
            }

            long canBuy = Math.min(gain, remBudget / price);
            totalCopies += canBuy * 2;
            remBudget -= canBuy * price;

            if (remBudget < price) {
                break;
            }
        }

        totalCopies += remBudget / minPrice;

        return (int) totalCopies;
    }
}