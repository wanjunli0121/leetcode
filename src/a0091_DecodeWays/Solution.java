/*
A message containing letters from A-Z is being encoded to numbers
using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits,
determine the total number of ways to decode it.
For example,
Given encoded message "12",
it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.
*/

package a0091_DecodeWays;

public class Solution {

    public int numDecodings(String s) {
        int pre = 1, cur = 1;
        for (int i = 0; i < s.length(); i++) {
            int t = 0;
            char c1 = s.charAt(i);
            if (c1 != '0') {
                t += cur;
            }
            if (i > 0) {
                char c2 = s.charAt(i - 1);
                if (c2 != '0' && (c2 - '0') * 10 + (c1 - '0') <= 26) {
                    t += pre;
                }
            }
            pre = cur;
            cur = t;
        }
        return cur;
    }

}
