package LeetCode.Easy;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class _66_PlusOne {
    public int[] plusOne(int[] digits) {
        int[] result;
        boolean isCarray = false;
        isCarray = plusOne(digits, isCarray);
        result = getResult(digits, isCarray);
        return result;
    }

    private boolean plusOne(int[] digits, boolean isCarray) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] >= 10) {
                if (i == 0) {
                    isCarray = true;
                } else {
                    digits[i - 1]++;
                }
                digits[i] -= 10;
            }
        }
        return isCarray;
    }

    private int[] getResult(int[] digits, boolean isCarray) {
        int[] result;
        int index;
        if (isCarray) {
            result = new int[digits.length + 1];
            result[0] = 1;
            index = 1;
        } else {
            result = new int[digits.length];
            index = 0;
        }
        for (int i = 0; i < digits.length; i++) {
            result[index++] = digits[i];
        }
        return result;
    }
}
