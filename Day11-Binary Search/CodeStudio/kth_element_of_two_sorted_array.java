import java.util.*;
public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        // Write your code here.
		if (m > n) {
            return ninjaAndLadoos(row2, row1, n, m, k);
        }

        if (m == 0) {
            return row2[k - 1];
        }

        if (k == 1) {
            return Math.min(row1[0], row2[0]);
        }

        int i = Math.min(m, k / 2);
        int j = Math.min(n, k / 2);

        if (row1[i - 1] > row2[j - 1]) {
            int newRow2[] = Arrays.copyOfRange(row2, j, n);

            return ninjaAndLadoos(row1, newRow2, m, n - j, k - j);
        }

        int newRow1[] = Arrays.copyOfRange(row1, i, n);

        return ninjaAndLadoos(newRow1, row2, m - i, n, k - i);
    }
}
