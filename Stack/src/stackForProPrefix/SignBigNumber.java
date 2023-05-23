
package stackForProPrefix;
public class SignBigNumber {
    public static String diff(String numStr1, String numStr2) {
        char[] s1 = numStr1.toCharArray();
        char[] s2 = numStr2.toCharArray();
        int l1 = s1.length;
        int l2 = s2.length;
        if (l1 < l2 || (l1 == l2 && s1[0] < s2[0])) {
            char[] t = s1;
            s1 = s2;
            s2 = t;

            int tt = l1;
            l1 = l2;
            l2 = tt;
        }
        int k = l1 - 1;
        int carry = 0;
        int j = l2 - 1;
        while (k >= 0 && j >= 0) {
            int result = Character.digit(s1[k], 10) - Character.digit(s2[j], 10) - carry;
            carry = result < 0 ? 1 : 0;
            if (carry > 0) {
                result = 10 + result;
            }
            s1[k] = Character.forDigit(result, 10);
            j--;
            k--;
        }

        while (k >= 0 && carry == 1) {
            int result = Character.digit(s1[k], 10) - carry;
            carry = result < 0 ? 1 : 0;
            if (carry > 0) {
                result = 10 + result;
            }
            s1[k--] = Character.forDigit(result, 10);
        }
        int InHeadResultString = 0;
        for (char x : s1) {
            if (x == '0') {
                InHeadResultString++;
            } else {
                break;
            }
        }
        char[] result = new char[s1.length - InHeadResultString];
        for (int i = InHeadResultString, resultCounter = 0; i < s1.length; i++, resultCounter++) {
            result[resultCounter] = s1[i];
        }
        if (carry > 0) {
            result[0] = 8;
        }

        return new String(result);
    }

    public static String add(String numStr1, String numStr2) {
        if (numStr1.contains("-")) {
            numStr1 = numStr1.substring(1);
            if (numStr2.contains("-")) {
                numStr2 = numStr2.substring(1);
            } else {
                return diff(numStr1, numStr2);
            }
        } else {
            if (numStr2.contains("-")) {
                numStr2 = numStr2.substring(1);
                return diff(numStr1, numStr2);
            }
        }

        char[] s1 = numStr1.toCharArray();
        char[] s2 = numStr2.toCharArray();
        int l1 = s1.length;
        int l2 = s2.length;
        if (l1 < l2) {
            char[] t = s1;
            s1 = s2;
            s2 = t;

            int tt = l1;
            l1 = l2;
            l2 = tt;
        }
        int k = l1 - 1;
        int carry = 0;
        int j = l2 - 1;
        while (k >= 0 && j >= 0) {
            int sum = Character.digit(s1[k], 10) + Character.digit(s2[j], 10) + carry;
            carry = sum >= 10 ? 1 : 0;
            if (carry > 0) {
                sum -= 10;
            }
            s1[k] = Character.forDigit(sum, 10);
            j--;
            k--;
        }

        while (k >= 0 && carry == 1) {
            int sum = Character.digit(s1[k], 10) + carry;
            carry = sum > 10 ? 1 : 0;
            if (carry > 0) {
                sum -= 10;
            }
            s1[k--] = Character.forDigit(sum, 10);
        }
        return carry > 0 ? "1" + new String(s1) : new String(s1);
    }

    public static String shiftLeft(String numStr, int n) {
        if (numStr.equals("0")) {
            return "0";
        }
        String extra = "";
        for (int i = 0; i < n; i++) {
            extra += "0";
        }
        return numStr + extra;
    }

    public static String multiply(String numStr, char c) {
        if (c == '0') {
            return "0";
        }
        char[] s1 = numStr.toCharArray();
        char[] s = new char[s1.length + 1];
        int carry = 0;
        int k = s.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            int result = (c - '0') * (s1[i] - '0') + carry;
            carry = result / 10;
            s[k] = Character.forDigit(result % 10, 10);
            k--;
        }
        if (carry > 0) {
            return Character.forDigit(carry, 10) + new String(s1);
        }
        return new String(s1);
    }

    public static String multiply(String numStr1, String numStr2) {
        EStatusOfNumbers checkSign = EStatusOfNumbers.NEGATIVE;
        if (numStr1.contains("-")) {
            numStr1 = numStr1.substring(1);
            if (numStr2.contains("-")) {
                numStr2 = numStr2.substring(1);
                checkSign = EStatusOfNumbers.POSITIVE;
            } else {
                checkSign = EStatusOfNumbers.NEGATIVE;
            }
        } else {
            if (numStr2.contains("-")) {
                numStr2 = numStr2.substring(1);
                checkSign = EStatusOfNumbers.NEGATIVE;
            } else {
                checkSign = EStatusOfNumbers.POSITIVE;
            }
        }
        int l = numStr2.length() - 1;
        String s = "0";
        String multResult, shiftResult;
        for (int i = l; i >= 0; i--) {
            multResult = multiply(numStr1, numStr2.charAt(i));
            shiftResult = shiftLeft(multResult, l - i);
            s = add(s, shiftResult);
        }
        return checkSign == EStatusOfNumbers.POSITIVE ? s : "-" + s;
    }

    public static void main(String[] args) {
        String s1 = "-982561895308002199923497037034";
        String s2 = "7325888353267884700000711023246913560";
        System.out.format("S1: %60s\n", s1);
        System.out.format("S2: %60s\n", s2);
        String s3 = add(s1, s2);
        System.out.format("S3: = S1 + S2 %50s\n", s3);
        String s4 = "-123456780001200118901065734";
        String s5 = "200000000000";
        System.out.format("S4: %60s\n", s4);
        System.out.format("S5: %60s\n", s5);
        String s6 = multiply(s4, s5);
        System.out.format("S6 = S3 * S4: %50s\n", s6);

    }
}
