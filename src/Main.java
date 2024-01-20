import java.util.HashMap;

public class Main {
    static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public static void main(String[] args) {
        System.out.println("5 steps: " + climbStairs(5)); // Expected result is 8
        System.out.println("3 steps: " + climbStairs(3)); // Expected result is 3
        System.out.println("2 steps: " + climbStairs(2)); // Expected result is 2
        System.out.println("1 step: " + climbStairs(1));  // Expected result is 1
        System.out.println("10 steps: " + climbStairs(10)); // A larger case, expected result is 89
    }

    static int climbStairs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 1 || n == 2) {
            return n;
        }

        if (n > 2) {
            memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return memo.get(n);
    }
}