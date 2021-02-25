package strings;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 10;
        int mem[] = new int[n];
        for (int i=0; i< n; i++) {
            System.out.println(fib(i, mem));
        }
    }

    /**
     * Prints the fibonacci series upto n numbers
     * @param n
     * @param memory to avoid recalcuation of fibonacci
     * @return
     */
    private static int fib(int n, int[] memory) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (memory[n] > 0) return memory[n];
        memory[n] = fib(n-1, memory) + fib(n-2, memory);
        return memory[n];
    }
}
