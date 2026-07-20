class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check if string is empty after skipping spaces
        if (i == n) {
            return 0;
        }

        // 2. Check for sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert characters to integer and handle rounding/overflow
        int result = 0;
        while (i < n) {
            char curr = s.charAt(i);
            
            // Stop reading if a non-digit character is encountered
            if (curr < '0' || curr > '9') {
                break;
            }

            int digit = curr - '0';

            // 4. Check for overflow/underflow before multiplying by 10
            // Integer.MAX_VALUE is 2147483647 (ends in 7)
            // Integer.MIN_VALUE is -2147483648 (ends in 8)
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}