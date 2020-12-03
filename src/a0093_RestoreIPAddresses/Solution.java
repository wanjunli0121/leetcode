/*
Given a string containing only digits,
restore it by returning all possible valid IP address combinations.
For example:
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

package a0093_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> address = new ArrayList<String>();
        restoreIpAddresses(address, s, "", 0, 0);
        return address;
    }

    private void restoreIpAddresses(List<String> address, String s, String cur, int count, int start) {
        if (count == 4) {
            if (start == s.length()) {
                address.add(cur);
            }
            return;
        }
        for (int i = start + 1; i < start + 4 && i <= s.length(); i++) {
            String part = s.substring(start, i);
            if ((part.startsWith("0") && part.length() > 1) || (Integer.parseInt(part) > 255)) {
                return;
            }
            String t = cur + part;
            if (count != 3) {
                t += ".";
            }
            restoreIpAddresses(address, s, t, count + 1, i);
        }
    }

}
