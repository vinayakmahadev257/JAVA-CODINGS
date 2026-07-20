class Solution {
    public int fib(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int next = a + b; // 1 2 3 5
            a = b;            // 1 1 2 3
            b = next;         // 1 2 3 5
        }

        return b;
    }
}