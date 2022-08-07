class Solution {
    public String getPermutation(int n, int k) {
        char[] digits = new char[n];
        for (int i = 0; i < n; i++) {
            digits[i] = (char)('1' + i);
        }
        int nextFactorial = 1;
        for (int i = 2; i < n; i++) {
            nextFactorial *= i;
        }
        k -= 1;
        for (int pos = 0; pos < n - 1; pos++) {
            int digitPos = k / nextFactorial + pos;
            for (int j = digitPos; j > pos; j--) {
                char temp = digits[j];
                digits[j] = digits[j - 1];
                digits[j - 1] = temp;
            }
            k %= nextFactorial;
            nextFactorial /= n - 1 - pos;
        }
        return new String(digits);
    }
}