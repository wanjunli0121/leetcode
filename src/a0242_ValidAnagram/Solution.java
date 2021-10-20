/*
Given two strings s and t,
return true if t is an anagram of s, and false otherwise.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
Constraints:
1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.
Follow up: What if the inputs contain Unicode characters?
How would you adapt your solution to such a case?
*/

package a0242_ValidAnagram;

import java.util.HashMap;

public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            map.put(c1, map.containsKey(c1) ? map.get(c1) + 1 : 1);
            char c2 = t.charAt(i);
            map.put(c2, map.containsKey(c2) ? map.get(c2) - 1 : -1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

}
