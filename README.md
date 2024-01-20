## Introduction

This Java program solves the classic problem of counting the number of distinct ways to climb a staircase. Given a staircase with `n` steps, each time you can either climb 1 or 2 steps. The program efficiently calculates the number of distinct ways you can reach the top of the stairs.

## Algorithm

### **1. Dynamic Programming with Memoization**

#### Logic

- The algorithm uses a top-down dynamic programming approach with memoization. 
- It stores the results of subproblems in a HashMap to avoid redundant calculations.
- The base cases are when `n` is 1 or 2, where the number of ways is equal to `n` itself.
- For `n > 2`, the number of ways is the sum of ways to climb `n - 1` steps and `n - 2` steps.

#### Complexity Analysis

- **Time Complexity:** O(n) - Each step from 1 to `n` is calculated once due to memoization.
- **Space Complexity:** O(n) - The extra space is used for the memoization HashMap storing up to `n` key-value pairs.

### Code Snippet

```java
import java.util.HashMap;

public class Main {
    static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        System.out.println("5 steps: " + climbStairs(5)); // Expected result is 8
        System.out.println("3 steps: " + climbStairs(3)); // Expected result is 3
        System.out.println("2 steps: " + climbStairs(2)); // Expected result is 2
        System.out.println("1 step: " + climbStairs(1));  // Expected result is 1
        System.out.println("10 steps: " + climbStairs(10)); // Expected result is 89
    }

    static int climbStairs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 1 || n == 2) {
            return n;
        }
        memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return memo.get(n);
    }
}
```