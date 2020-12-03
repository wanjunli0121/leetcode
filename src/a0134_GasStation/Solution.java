/*
There are N gas stations along a circular route,
where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas
to travel from station i to its next station (i+1).
You begin the journey with an empty tank at one of the gas stations.
Return the starting gas station's index if you can travel around the circuit once,
otherwise return -1.
Note:
The solution is guaranteed to be unique.
*/

package a0134_GasStation;

public class Solution {

    // https://leetcode.com/problems/gas-station/solution/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total_tank = 0, cur_tank = 0;
        for (int i = 0; i < gas.length; i++) {
            int t = gas[i] - cost[i];
            total_tank += t;
            cur_tank += t;
            if (cur_tank < 0) {
                start = i + 1;
                cur_tank = 0;
            }
        }
        return total_tank < 0 ? -1 : start;
    }

}
