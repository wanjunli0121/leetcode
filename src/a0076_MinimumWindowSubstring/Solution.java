/*
Given a string S and a string T,
find the minimum window in S which will contain all the characters in T in complexity O(n).
Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:
If there is no such window in S that covers all characters in T,
return the empty string "".
If there is such window,
you are guaranteed that there will always be only one unique minimum window in S.
*/

package a0076_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // https://leetcode.com/problems/minimum-window-substring/solution/
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> targetCounts = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!targetCounts.containsKey(c)) {
                targetCounts.put(c, 1);
            } else {
                targetCounts.put(c, targetCounts.get(c) + 1);
            }
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = targetCounts.size();

        // Left and Right pointer
        int left = 0, right = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        int windowLen = -1, windowLeft = 0, windowRight = 0;

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            if (!windowCounts.containsKey(c)) {
                windowCounts.put(c, 1);
            } else {
                windowCounts.put(c, windowCounts.get(c) + 1);
            }

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (targetCounts.containsKey(c) && windowCounts.get(c).equals(targetCounts.get(c))) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (left <= right && formed == required) {
                c = s.charAt(left);
                // Save the smallest window until now.
                if (windowLen == -1 || right - left + 1 < windowLen) {
                    windowLen = right - left + 1;
                    windowLeft = left;
                    windowRight = right;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                left++;

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (targetCounts.containsKey(c) && windowCounts.get(c) < targetCounts.get(c)) {
                    formed--;
                }
            }

            // Keep expanding the window once we are done contracting.
            right++;
        }

        return windowLen == -1 ? "" : s.substring(windowLeft, windowRight + 1);
    }

}
