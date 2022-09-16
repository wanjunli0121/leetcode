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
        List<String> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    private void backtrack(List<String> list, List<String> tempList, String s, int start) {
        if (tempList.size() == 4) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < tempList.size() - 1; i++) {
                    sb.append(tempList.get(i));
                    sb.append(".");
                }
                sb.append(tempList.get(tempList.size() - 1));
                list.add(sb.toString());
            }
        } else {
            for (int i = 1; i < 4 && start + i <= s.length(); i++) {
                String t = s.substring(start, start + i);
                if ((i > 1 && t.charAt(0) == '0') || Integer.parseInt(t) > 255) {
                    return;
                }
                tempList.add(t);
                backtrack(list, tempList, s, start + i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
