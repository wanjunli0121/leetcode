/*
You are climbing a stair case.
It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps.
In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
Example 1:
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

package a0070_ClimbingStairs;

public class Solution {

    // This is basically a fibonacci number,
    // with the starting numbers as 1 and 2, instead of 1 and 1.
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int lastTimeOneStep = 2, lastTimeTwoSteps = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = lastTimeOneStep + lastTimeTwoSteps;
            lastTimeTwoSteps = lastTimeOneStep;
            lastTimeOneStep = result;
        }
        return result;
    }

}
