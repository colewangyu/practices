package LeetCode.Easy;

public class _67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        boolean isCarry = calculate(result, 0, a, b);
        if (isCarry) result.append(1);
        return result.reverse().toString();
    }

    private boolean calculate(StringBuilder result, int carry, String a, String b) {
        int indexOfA = a.length() - 1;
        int indexOfB = b.length() - 1;
        while(indexOfA >= 0 || indexOfB >= 0) {
            int sum = carry;
            if(indexOfA >= 0) {
                sum += a.charAt(indexOfA--) - '0';
            }
            if (indexOfB >= 0) {
                sum += b.charAt(indexOfB--) - '0';
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        return carry == 1;
    }
}
