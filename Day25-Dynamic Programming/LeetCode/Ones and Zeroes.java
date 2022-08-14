class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], 0);
        }

        int[] nums = new int[]{0,0};
        for (String str : strs) {
            nums = calculate(str);
            for (int j = m; j >= nums[0]; j--) {
                for (int k = n; k >= nums[1]; k--) {
                    if (j>=nums[0] && k>=nums[1]) {
                        dp[j][k] = Math.max(dp[j][k], dp[j-nums[0]][k-nums[1]]+1);
                    } else {
                        dp[j][k] = dp[j][k];
                    }
                }
            }
        }

        return dp[m][n];
    }
    
    private int[] calculate(String str) {
        int[] res = new int[2];
        Arrays.fill(res, 0);

        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                res[0]++;
            } else if (ch == '1') {
                res[1]++;
            }
        }

        return res;
    }
}