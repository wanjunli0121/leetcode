/*
You are given an even number of people num_people that stand around a circle
and each person shakes hands with someone else,
so that there are num_people / 2 handshakes total.
Return the number of ways these handshakes could occur such that none of the handshakes cross.
Since this number could be very big,
return the answer mod 10^9 + 7
Constraints:
2 <= num_people <= 1000
num_people % 2 == 0
*/

package a1259_HandshakesThatDoNotCross;

public class Solution {

    // https://leetcode.com/problems/handshakes-that-dont-cross/discuss/430483/Java-9-lines-DP-Solution-with-details-explain
    public int numberOfWays(int num_people) {
        long M = (long)1e9 + 7;
        long[] cache = new long[num_people + 1];
        cache[0] = 1;
        for (int i = 2; i <= num_people; i += 2) {
            for (int j = 2; j <= i; j += 2) {
                cache[i] = (cache[i] + (cache[j - 2] * cache[i - j])) % M;
            }
        }
        return (int)cache[num_people];
    }

}
